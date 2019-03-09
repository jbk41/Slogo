package Visualization;


import Executable.Executable;
import Executable.TurtleState;
import backend.BackendModel;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
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
import Executable.TurtleState;
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
    private ArrayList<Turtle> turtleList;
    private ArrayList<Executable> commandHistory;

    @Override
    public void start(Stage stage){
        Stage primaryStage = stage;
        Group root = new Group();
        turtleMap = new HashMap<Double, Turtle>();
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
        //todo: grab the id of the turtle before executing
        for (Executable commandToRun : backend.getCommands()) {
            if (commandToRun instanceof TurtleState) {
                runTurtleCommand(commandToRun);
            }
            if(commandToRun instanceof ColorPaletteEntry){
            }
            if(commandToRun instanceof ErrorMessage){
                System.out.println(((ErrorMessage) commandToRun).getError());
                console.getItems().add(((ErrorMessage) commandToRun).getError());
            }
            if(commandToRun instanceof EnvironmentState){
            }
        }
//        if (backend.getCommands().get(0) instanceof TurtleState){
//            Turtle turtle = turtleMap.get(((TurtleState) backend.getCommands().get(0)).getID());
//            turtle.moveTurtle((TurtleState)backend.getCommands().get(0), myStates);
//        }
//        turtle.moveTurtle(backend.getCommands(),myStates);
    }
    private VBox createTurtleEnvironment(){
        turtleDisplay = new TurtleDisplay(width, height, padding);
        VBox controls = createSettingsButtons(turtle, turtleDisplay);
        VBox display = new VBox(15, turtleDisplay, controls);
        display.setPadding(new Insets(padding,padding,padding,padding));
        return display;
    }
    private VBox createSettingsButtons(Turtle turtle, TurtleDisplay turtleDisplay){
        ColorDropDown settingsBox = new ColorDropDown(padding, turtleDisplay);
        PenColorDropDown penColorDropDown = new PenColorDropDown(padding, turtle);
        LanguagesDropDown languagesDropDown = new LanguagesDropDown();
        PenSize penSize = new PenSize(turtle);
        Button playButton = new Button("Play");
        backend = new BackendModel();
        playButton.setOnAction(e -> playTheCommands(languagesDropDown));
        Button help = createHelpButton();
        HBox top = new HBox(6, playButton, help, settingsBox, createUndoButton());
        HBox bottom = new HBox(6, penColorDropDown, languagesDropDown, penSize, addWorkspace());
        VBox controls = new VBox(6, top, bottom);
        controls.setMaxWidth(width/2);
        return controls;
    }
    private void playTheCommands(LanguagesDropDown languagesDropDown){
        String commands = textEditor.getText();
        console.getItems().add(commands);
        try {
            String language = languagesDropDown.getValue().toString();
            backend.setLanguage(language);
            backend.clearCommandList();
            backend.interpret(commands);
            for (Executable commandToRun : backend.getCommands()) {
                System.out.println("runs");
                if (commandToRun instanceof TurtleState) {
                    runTurtleCommand(commandToRun);
                }
                if(commandToRun instanceof ColorPaletteEntry){
                }
                if(commandToRun instanceof ErrorMessage){
                    console.getItems().add(((ErrorMessage) commandToRun).getError());
                }
                if(commandToRun instanceof EnvironmentState){
                }
            }
            myUserDefined.getItems().clear();
            myUserDefined.getItems().add("Variables and Commands: ");
            savedVarMap = backend.getVarMap();
//            System.out.println(savedVarMap);
            for (String key : savedVarMap.keySet()) {
                myUserDefined.getItems().add(key + " = " + savedVarMap.get(key).toString());
            }
            ParallelTransition parallelTransition = new ParallelTransition();
            for(double id: turtleMap.keySet()){
                SequentialTransition sequentialTransition = turtleMap.get(id).getST();
                parallelTransition.getChildren().add(sequentialTransition);
                turtleMap.get(id).getST().getChildren().removeAll();
            }
            parallelTransition.play();
            parallelTransition.getChildren().removeAll();

        } catch(NullPointerException ex){
            showError("Please Choose a Language");
        }
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
//        undo.setOnAction(e -> undoLastCommand());
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

    private Turtle getTurtle(int id){
        return turtle;
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
//        System.out.println(savedVarMap);
        for (String keyVal : savedVarMap.keySet()) {
            myUserDefined.getItems().add(keyVal + " = " + savedVarMap.get(keyVal).toString());
//            System.out.println(key);
        }
        return inputBox;
    }

    private Console getStateConsole(){
        return myStates;
    }

//    private void undoLastCommand() {
//        TurtleState lastState = backend.getCommands().get(backend.getCommands().size() - 2);
//        //TODO: some way to account for the different id
//        System.out.println(lastState.getX());
//        System.out.println(lastState.getY());
//        System.out.println(lastState.getDeg());
//        System.out.println(lastState.getPenState());
//    }
    /*
    private void undoLastCommand(Console stateConsole){

        if (commandHistory.size() > 1) {
//            TurtleState lastState = backend.getCommands().get(backend.getCommands().size() - 1);
//            TurtleState prevState = backend.getCommands().get(backend.getCommands().size() - 2);
//            backend.getCommands().remove(backend.getCommands().size() - 1);
            TurtleState lastState = commandHistory.get(commandHistory.size() - 1);
            TurtleState prevState = commandHistory.get(commandHistory.size() - 2);
            commandHistory.remove(commandHistory.size() - 1);
            if (lastState.getX() != prevState.getX() || prevState.getY() != lastState.getY()) {
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
            backend.getTurtleManager().setMyDegrees(lastState.getMyDegrees());
            stateConsole.getItems().clear();
            stateConsole.getItems().add("Turtle State" + "\r\n" + turtle.getState(prevState.getX(), prevState.getY(), prevState.getDeg(), prevState.getPenState()));
        }
        else{
            stateConsole.getItems().clear();
            stateConsole.getItems().add("Turtle State" + "\r\n" + turtle.getState(0,0,0,false));
            turtle.setDefaultTurtleLocation();
        }
    }
    */

    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
