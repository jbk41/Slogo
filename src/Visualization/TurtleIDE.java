package Visualization;


import Executable.Executable;
import Executable.TurtleState;
import backend.BackendModel;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import Executable.EnvironmentState;
import Executable.ErrorMessage;
import Executable.ColorPaletteEntry;

public class TurtleIDE extends Application {
    private static final String title = "Turtle IDE";
    private static final Paint backgroundColor = Color.AQUA;
    private static final int width = 1050;
    private static final int height = 680;
    private static final int padding = 15;
    private TextEditor textEditor;
    private TurtleDisplay turtleDisplay;
    private Console console;
    private Console myUserDefined;
    private Console myStates;
    private BackendModel backend;
    private Map <String, Double> savedVarMap;
    private Turtle turtle;
    private Map <Double, Turtle> turtleMap;
    private ColorDropDown backgroundColorSettings;
    private PenColorDropDown penColorDropDown;
    private ArrayList<TurtleState> movementHistory;
    private ParallelTransition parallelTransition;
    private SequentialTransition prevSequential = new SequentialTransition();
    private SequentialTransition sequenceHistory;

    @Override
    public void start(Stage stage){
        Stage primaryStage = stage;
        Group root = new Group();
        turtleMap = new HashMap<>();
        movementHistory= new ArrayList<TurtleState>();
        var startScene = new Scene(root, width, height, backgroundColor);
        HBox IDE = new HBox(createUserBox(), createTurtleEnvironment());
        root.getChildren().add(IDE);
        primaryStage.setScene(startScene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }

    private VBox createUserBox(){
        textEditor = new TextEditor(width, height);
        console = new Console(width, height, padding, "Console");
        console.setOnMouseClicked(e -> reInterpret(console.getSelectionModel().getSelectedItem().toString()));
        VBox user = new VBox(15, textEditor, displayUserDefined(), console);
        user.setPadding(new Insets(padding, padding,padding,padding));
        return user;
    }

    private void reInterpret(String command){
        backend.clearCommandList();
        backend.interpret(command);
        for (Executable commandToRun : backend.getCommands()) {
            runTurtleCommand(commandToRun);
        }
        createTransition();
    }
    private VBox createTurtleEnvironment(){
        turtleDisplay = new TurtleDisplay(width, height, padding);
        VBox controls = createSettingsButtons(turtle, turtleDisplay);
        VBox display = new VBox(15, turtleDisplay, controls);
        display.setPadding(new Insets(padding,padding,padding,padding));
        return display;
    }

    private VBox createSettingsButtons(Turtle turtle, TurtleDisplay turtleDisplay){
        backgroundColorSettings = new ColorDropDown(padding, turtleDisplay);
        penColorDropDown = new PenColorDropDown(padding, turtleDisplay);
        LanguagesDropDown languagesDropDown = new LanguagesDropDown();
        PenSize penSize = new PenSize(turtleDisplay);
        Button playButton = new Button("Play");
        backend = new BackendModel();
        playButton.setOnAction(e -> playTheCommands(languagesDropDown));
        Button help = createHelpButton();
        HBox top = new HBox(6, playButton, help, backgroundColorSettings, createUndoButton());
        HBox bottom = new HBox(6, penColorDropDown, languagesDropDown, penSize, addWorkspace());
        VBox controls = new VBox(6, top, bottom);
        controls.setMaxWidth(width/2);
        return controls;
    }
    private void playTheCommands(LanguagesDropDown languagesDropDown){
        sequenceHistory = new SequentialTransition();
        sequenceHistory.getChildren().addAll(prevSequential.getChildren());
        String commands = textEditor.getText();
        try {
            String language = languagesDropDown.getValue().toString();
            backend.setLanguage(language);
            backend.clearCommandList();
            backend.interpret(commands);
            for (Executable commandToRun : backend.getCommands()) {
                if (commandToRun instanceof TurtleState) {
                    movementHistory.add((TurtleState)commandToRun);
                    runTurtleCommand(commandToRun);
                }
                if(commandToRun instanceof ErrorMessage){
                    displayError(commandToRun);
                }
                if(commandToRun instanceof EnvironmentState) {
                    changeEnvironment(commandToRun);
                }
                displayVariables();
            }
            displayVariables();
            createTransition();
        } catch(NullPointerException ex){
            showError("Please Choose a Language");
        }
    }

    private void displayError(Executable commandToRun){
        showError(((ErrorMessage)commandToRun).getError());
        console.getItems().add(((ErrorMessage) commandToRun).getError());
    }

    private void displayVariables(){
        myUserDefined.getItems().clear();
        myUserDefined.getItems().add("Variables and Commands: ");
        savedVarMap = backend.getVarMap();
        for (String key : savedVarMap.keySet()) {
            myUserDefined.getItems().add(key + " = " + savedVarMap.get(key).toString());
        }
    }

    private void changeEnvironment(Executable commandToRun){
        EnvironmentState environmentCommand = (EnvironmentState) commandToRun;
        double penSize = environmentCommand.getPenSize();
        turtleDisplay.setPEN_SIZE((int)penSize);
        if ((environmentCommand.getBackgroundIndex() != 0)) {
            int colorIndex =(int)(environmentCommand.getBackgroundIndex());
            Paint color = backgroundColorSettings.getColorMap().get(colorIndex);
            turtleDisplay.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        if (environmentCommand.getColorIndex()!= 0){
            int penColorIndex = (int)environmentCommand.getColorIndex();
            Paint color = penColorDropDown.getColorMap().get(penColorIndex);
            turtleDisplay.setPEN_COLOR(color);
        }
    }
    private void createTransition(){
        parallelTransition = new ParallelTransition();
        for(double id: turtleMap.keySet()){
            SequentialTransition sequentialTransition = turtleMap.get(id).getST();
            sequentialTransition.getChildren().removeAll(sequenceHistory.getChildren());
            if (!sequentialTransition.getChildren().isEmpty()) {
                parallelTransition.getChildren().add(sequentialTransition);
            }
        }
        parallelTransition.play();
    }

    private void runTurtleCommand(Executable commandToRun){
        TurtleState command = (TurtleState)commandToRun;
        if (!turtleMap.containsKey(command.getID()) && !command.getClear()) {
            Turtle newTurtle = new Turtle(turtleDisplay, turtleDisplay.getCanvas());
            turtleMap.put(command.getID(), newTurtle);
        }
        checkClear((TurtleState)commandToRun);
        if (!command.getClear()) {
            turtle = turtleMap.get(command.getID());
            turtle.moveTurtle(command, myStates);
            prevSequential = turtle.getST();
        }
    }

    private void checkClear(TurtleState command){
        if (command.getClear()){
            for (Turtle turt: turtleMap.values()){
                turtleDisplay.getChildren().remove(turt.getTurtleImageView());
            }
            turtleMap.clear();
            turtleDisplay.createNewCanvas();
            return;
        }
    }

    private Button createHelpButton(){
        Button help = new Button("Help");
        help.setOnAction(e -> createHelpScreen());
        return help;
    }

    private Button createUndoButton(){
        Button undo = new Button("Undo");
        undo.setOnAction(e -> undoLastCommand(myStates));
        return undo;
    }

    private Button addWorkspace(){
        Button newWorkspace = new Button("Add Workspace");
        newWorkspace.setOnAction(e -> start(new Stage()));
        return newWorkspace;
    }

    private void createHelpScreen(){
        try {
            HelpScreen help = new HelpScreen();
            help.displayHelpScreen();
        } catch (Exception e){
            showError("Wrong File");
        }
    }
    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("There was an error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private HBox displayUserDefined(){
        myUserDefined = new Console(width /2 , height, padding, "Variables and Commands");
        myUserDefined.setPrefWidth(width/4 - padding *2);
        myUserDefined.setOnMouseClicked(e -> createVariableScreen(myUserDefined.getSelectionModel().getSelectedItem().toString().substring(0, myUserDefined.getSelectionModel().getSelectedItem().toString().indexOf('=') )));
        myStates = new Console(width / 2, height, padding, "Turtle State");
        myStates.setPrefWidth(width/4 - padding);
        HBox user = new HBox(15, myUserDefined, myStates);
        return user;
    }
    private Dialog createVariableScreen(String rawKey){
        final String key = rawKey.trim();
        Dialog inputBox = new TextInputDialog("Change the input");
        inputBox.setHeaderText("Enter the new value for " + key);
        inputBox.setContentText("Value: ");
        Optional<String> result = inputBox.showAndWait();
        result.ifPresent(e -> backend.setVariable(key, Double.parseDouble(result.get())));
        savedVarMap = backend.getVarMap();
        myUserDefined.getItems().clear();
        myUserDefined.getItems().add("Variables and Commands: ");
        for (String keyVal : savedVarMap.keySet()) {
            myUserDefined.getItems().add(keyVal + " = " + savedVarMap.get(keyVal).toString());
        }
        return inputBox;
    }

    private void undoLastCommand(Console stateConsole){
        if (movementHistory.size() > 1) {
            TurtleState lastState = movementHistory.get(movementHistory.size() - 1);
            TurtleState prevState = movementHistory.get(movementHistory.size() - 2);
            movementHistory.remove(movementHistory.size() - 1);
            if (lastState.getX() != prevState.getX() || prevState.getY() != lastState.getY()){
                eraseLine(prevState);
            }
            stateConsole.getItems().clear();
            stateConsole.getItems().add("Turtle State" + "\r\n" + turtle.getState(prevState.getX(), prevState.getY(), prevState.getDeg(), prevState.getPenState()));
        }
        else{
            stateConsole.getItems().clear();
            stateConsole.getItems().add("Turtle State" + "\r\n" + turtle.getState(0,0,0,false));
            turtle.setDefaultTurtleLocation();
        }
    }

    private void eraseLine(TurtleState prevState){
        double oldX = turtle.getTurtleImageView().getBoundsInParent().getCenterX();
        double oldY = turtle.getTurtleImageView().getBoundsInParent().getCenterY();
        turtle.getTurtleImageView().setX(turtle.getDefaultX() + prevState.getX());
        turtle.getTurtleImageView().setY(turtle.getDefaultY() - prevState.getY());
        double newX = turtle.getTurtleImageView().getBoundsInParent().getCenterX();
        double newY = turtle.getTurtleImageView().getBoundsInParent().getCenterY();
        Paint color = turtle.getGraphics().getFill();
        turtle.getGraphics().setStroke(Color.WHITE);
        turtle.getGraphics().setLineWidth(turtle.getPenSize() + 1);
        turtle.getGraphics().strokeLine(oldX, oldY, newX, newY);
        turtle.getGraphics().setStroke(color);
        turtle.getGraphics().setLineWidth(turtle.getPenSize());
    }


    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
