package Visualization;


import backend.BackendModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

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
        VBox user = new VBox(15, textEditor, displayUserDefined(), console);
        user.setPadding(new Insets(padding, padding,padding,padding));
        return user;
    }
    private VBox createTurtleDisplay(){
        TurtleDisplay turtleDisplay = new TurtleDisplay(width, height, padding);
        Turtle turtle =  new Turtle(turtleDisplay, turtleDisplay.getCanvas());
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
        HBox top = new HBox(6, playButton, help, settingsBox);
        HBox bottom = new HBox(6, penColorDropDown, languagesDropDown, penSize);
        VBox controls = new VBox(6, top, bottom);
        controls.setMaxWidth(width/2);
        return controls;
    }
    private void playTheCommands(LanguagesDropDown languagesDropDown, Turtle turtle){
//        BackendModel backend = new BackendModel();
        // map of variables and respective values, display to the user
        //backend.getBackendManager().getVariableManager().getVariableMap();
        String commands = textEditor.getText();
        try {
            String language = languagesDropDown.getValue().toString();
            backend.setLanguage(language);
            backend.getCommandManager().clearCommandList();
            backend.interpret(commands);
            turtle.moveTurtle(backend.getCommands(),myStates);
            console.setText(console.getContent().toString() + "\r\n" + commands);
            myUserDefined.setText("Variables and Commands" +  "\r\n" + backend.getBackendManager().getVariableManager().getVariableMap().toString());
        }catch(NullPointerException ex){
            showError("Please Choose a Language");
        }
    }
    private Button createHelpButton(){
        Button help = new Button("Help");
        help.setOnAction(e -> createHelpScreen());
        return help;
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
        myStates = new Console(width / 2, height, padding, "Turtle State");
        myStates.setPrefWidth(width/4 - padding);
        HBox user = new HBox(15, myUserDefined, myStates);
        return user;
    }

    private void updateStates(){

    }
    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
