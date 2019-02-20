package Visualization;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class TurtleIDE extends Application {
    private static final String title = "Turtle IDE";
    private static final Paint backgroundColor = Color.AQUA;
    private static final int width = 1000;
    private static final int height = 680;
    private static final int padding = 15;
    private Console console;
    private TextEditor textEditor;
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
        console = new Console(width, height, padding);
        VBox user = new VBox(15, textEditor, console);
        user.setPadding(new Insets(padding, padding,padding,padding));

        return user;
    }

    private VBox createTurtleDisplay(){
        TurtleDisplay turtleDisplay = new TurtleDisplay(width, height, padding);
        ColorDropDown settingsBox = new ColorDropDown(padding, turtleDisplay);
        PlayTurtle play = new PlayTurtle(turtleDisplay, "Trial");
        PenColorDropDown penColorDropDown = new PenColorDropDown(padding, turtleDisplay);
        Button pause = new Button("Pause");
        Button reset = new Button("Reset");
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                turtleDisplay.setDefaultTurtleLocation();
            }
        });
        HBox controls = new HBox(5, play, pause, reset, settingsBox, penColorDropDown);
        VBox turtle = new VBox(15, turtleDisplay, controls);
        turtle.setPadding(new Insets(padding,padding,padding,padding));
        return turtle;
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
