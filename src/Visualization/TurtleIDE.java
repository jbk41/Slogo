package Visualization;

import TurtleData.TextReader;
import TurtleData.TextWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class TurtleIDE extends Application {
    private static final String title = "Turtle IDE";
    private static final Paint backgroundColor = Color.AQUA;
    private static final int width = 1050;
    private static final int height = 680;
    private static final int padding = 15;
    private Console console;
    private TextEditor textEditor;
    private Stage primaryStage;
    @Override
    public void start(Stage stage){
        primaryStage = stage;
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
        console = new Console(width, height, padding);
        VBox user = new VBox(15, textEditor, console);
        user.setPadding(new Insets(padding, padding,padding,padding));
        return user;
    }

    private VBox createTurtleDisplay(){
        TurtleDisplay turtleDisplay = new TurtleDisplay(width, height, padding);
        Turtle turtle =  new Turtle(turtleDisplay, turtleDisplay.getCanvas());
        ColorDropDown settingsBox = new ColorDropDown(padding, turtleDisplay);
        PenColorDropDown penColorDropDown = new PenColorDropDown(padding, turtle);
        LanguagesDropDown languagesDropDown = new LanguagesDropDown(padding, turtleDisplay);

        PlayTurtle play = new PlayTurtle(turtle, "Play");
        Button reset = createResetButton(turtle, turtleDisplay);
        Button save = createSaveButton();
        Button load = createLoadButton();
        HBox controls = new HBox(6, play, reset, save, load, settingsBox, penColorDropDown, languagesDropDown);
        VBox display = new VBox(15, turtleDisplay, controls);
        display.setPadding(new Insets(padding,padding,padding,padding));
        return display;
    }
    private Button createSaveButton(){
        Button save = new Button("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
                if (file != null) {
                    TextWriter textWriter = new TextWriter(file);
                    textWriter.writeTextFile(textEditor.getText());
                }
            }
        });
        return save;
    }
    private Button createResetButton(Turtle turtle, TurtleDisplay turtleDisplay){
        Button reset = new Button("Reset");
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                turtle.stopTurtle();
                Canvas canvas = turtleDisplay.createNewCanvas();
                turtle.changeCanvas(canvas);
                turtle.setDefaultTurtleLocation();
            }
        });
        return reset;
    }
    private Button createLoadButton(){
        Button load = new Button("Load");
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Load Previous Code");
                File file = fileChooser.showOpenDialog(primaryStage);
                TextReader textReader = new TextReader(file);
                textEditor.setText(textReader.getText());
            }
        });
        return load;
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
