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
import javafx.stage.Stage;

public class TurtleIDE extends Application {
    private static final String title = "Turtle IDE";
    private static final Paint backgroundColor = Color.AQUA;
    private static final int width = 1050;
    private static final int height = 680;
    private static final int padding = 15;
    private TextEditor textEditor;
    private Console console;

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
        HBox controls = createSettingsButtons(turtle, turtleDisplay);
        VBox display = new VBox(15, turtleDisplay, controls);
        display.setPadding(new Insets(padding,padding,padding,padding));
        return display;
    }
    private HBox createSettingsButtons(Turtle turtle, TurtleDisplay turtleDisplay){
        ColorDropDown settingsBox = new ColorDropDown(padding, turtleDisplay);
        PenColorDropDown penColorDropDown = new PenColorDropDown(padding, turtle);
        LanguagesDropDown languagesDropDown = new LanguagesDropDown();
        PenSize penSize = new PenSize(turtle);
        Button playButton = new Button("Play");
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BackendModel backend = new BackendModel();
                // map of variables and respective values, display to the user
                //backend.getBackendManager().getVariableManager().getVariableMap();
                String commands = textEditor.getText();
                try {
                    String language = languagesDropDown.getValue().toString();
                    backend.setLanguage(language);
                    backend.interpret(commands);
                    turtle.moveTurtle(backend.getCommands());
                    console.setText(console.getText() + commands + "\r\n");
                }catch(NullPointerException ex){
                    showError("Please Choose a Language");
                }
            }
        });
        Button help = createHelpButton();
        HBox controls = new HBox(6, playButton, help, settingsBox, penColorDropDown, languagesDropDown, penSize);
        return controls;
    }
    private Button createHelpButton(){
        Button help = new Button("Help");
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    HelpScreen.displayHelpScreen();
                } catch (Exception e){
                    showError("Wrong File");
                }
            }
        });
        return help;
    }
    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }


    private HBox displayUserDefined(){
        Console variables = new Console(width /2 , height, padding, "Variables and Commands");
        variables.setPrefWidth(width/4 - padding *2);
        Console commands = new Console(width / 2, height, padding, "Turtle State");
        commands.setPrefWidth(width/4 - padding);
        HBox user = new HBox(15, variables, commands);
        return user;
    }
    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
