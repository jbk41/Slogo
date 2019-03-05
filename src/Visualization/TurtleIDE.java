package Visualization;


import TurtleState.TurtleState;
import backend.BackendModel;
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

public class TurtleIDE extends Application {
    private static final String title = "Turtle IDE";
    private static final Paint backgroundColor = Color.AQUA;
    private static final int width = 1050;
    private static final int height = 680;
    private static final int padding = 15;
    private TextEditor textEditor;
    private Console console;
    private Console myUserDefined;
    private Console myStates;
    private BackendModel backend;
    private Map <String, Double> savedVarMap = new HashMap<>();
    private Turtle turtle;
    private ArrayList<TurtleState> commandHistory = new ArrayList<>();
    private ArrayList<Turtle> turtleList = new ArrayList<>();

    @Override
    public void start(Stage stage){
        Stage primaryStage = stage;
        Group root = new Group();
        var startScene = new Scene(root, width, height, backgroundColor);
        HBox IDE = new HBox(createUserBox(), createTurtleDisplay());
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
        backend.getCommandManager().clearCommandList();
        backend.interpret(command);
        //todo: grab the id of the turtle before executing
        turtle.moveTurtle(backend.getCommands(),myStates, commandHistory);
    }
    private VBox createTurtleDisplay(){
        TurtleDisplay turtleDisplay = new TurtleDisplay(width, height, padding);
        turtle =  new Turtle(turtleDisplay, turtleDisplay.getCanvas());
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
        playButton.setOnAction(e -> playTheCommands(languagesDropDown, turtle));
        Button help = createHelpButton();
        HBox top = new HBox(6, playButton, help, settingsBox, createUndoButton());
        HBox bottom = new HBox(6, penColorDropDown, languagesDropDown, penSize, addWorkspace());
        VBox controls = new VBox(6, top, bottom);
        controls.setMaxWidth(width/2);
        return controls;
    }
    private void playTheCommands(LanguagesDropDown languagesDropDown, Turtle turtle){
        String commands = textEditor.getText();
        try {
            String language = languagesDropDown.getValue().toString();
            backend.setLanguage(language);
            backend.getCommandManager().clearCommandList();
            backend.interpret(commands);
            turtle.moveTurtle(backend.getCommands(),myStates, commandHistory);
            console.getItems().add(commands);
            myUserDefined.getItems().clear();
            myUserDefined.getItems().add("Variables and Commands");
            savedVarMap = backend.getBackendManager().getVariableManager().getVariableMap();
            for (String key : savedVarMap.keySet()){
                myUserDefined.getItems().add(key + " = " + savedVarMap.get(key).toString());
            }
        }catch(NullPointerException ex){
            showError("Please Choose a Language");
        }
    }
    private Button createHelpButton(){
        Button help = new Button("Help");
        help.setOnAction(e -> createHelpScreen());
        return help;
    }

    private Button createUndoButton(){
        Button undo = new Button("Undo");
        undo.setOnAction(e -> undoLastCommand());
        return undo;
    }

    private Button addWorkspace(){
        Button newWorkspace = new Button("Add Workspace");
        newWorkspace.setOnAction(e -> start(new Stage()));
        return newWorkspace;
    }

    private void createHelpScreen(){
        try {
            HelpScreen.displayHelpScreen();
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
        Dialog inputBox = new TextInputDialog("");
        inputBox.setHeaderText("Enter the new value for " + key);
        inputBox.setContentText("Value: ");
        Optional<String> result = inputBox.showAndWait();
        result.ifPresent(e -> updateVariable(key,result));
        savedVarMap = backend.getBackendManager().getVariableManager().getVariableMap();
        return inputBox;
    }

    private void updateVariable(String key, Optional<String> result){
        backend.getBackendManager().getVariableManager().getVariableMap().put(key, Double.parseDouble(result.get()));
        myUserDefined.getItems().clear();
        myUserDefined.getItems().add("Variables and Commands");
        for (String keyString : savedVarMap .keySet()){
            myUserDefined.getItems().add(keyString + " = " + savedVarMap.get(keyString).toString());
        }
    }

    private void undoLastCommand(){
        if (commandHistory.size() > 1) {
//            TurtleState lastState = backend.getCommands().get(backend.getCommands().size() - 1);
//            TurtleState prevState = backend.getCommands().get(backend.getCommands().size() - 2);
//            backend.getCommands().remove(backend.getCommands().size() - 1);
            TurtleState lastState = commandHistory.get(commandHistory.size() - 1);
            TurtleState prevState = commandHistory.get(commandHistory.size() - 2);
            commandHistory.remove(commandHistory.size() - 1);
            //TODO: some way to account for the different id, not done just testing
            System.out.println(turtle.getTurtleImageView().getX());
            System.out.println(turtle.getTurtleImageView().getY());
            turtle.getTurtleImageView().setX(turtle.getTransXPos(lastState) - prevState.getXPos());
            turtle.getTurtleImageView().setY(turtle.getTransYPos(lastState) - prevState.getYPos());
            backend.getTurtleManager().setMyDegrees(lastState.getMyDegrees());

            System.out.println(turtle.getTurtleImageView().getX());
            System.out.println(turtle.getTurtleImageView().getY());

            System.out.println("X: " + lastState.getXPos());
            System.out.println("Y: " + lastState.getYPos());
            System.out.println("Deg: " + lastState.getMyDegrees());
            System.out.println("PD: " + lastState.getPenDown());
            System.out.println("Vis: " + lastState.getVisibility());
        }
        else{
            //TODO: decide if we want to implement extensive command history
            turtle.setDefaultTurtleLocation();
        }
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
