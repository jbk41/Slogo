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
        console = new Console(width, height, padding);
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
        Button playButton = new Button("Play");
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BackendModel backend = new BackendModel();
                // map of variables and respective values, display to the user
                //backend.getBackendManager().getVariableManager().getVariableMap();
                String commands = textEditor.getText();
                String language = languagesDropDown.getValue().toString();
                backend.setLanguage(language);
                backend.interpret(commands);
                turtle.moveTurtle(backend.getCommands());
                console.setText(console.getText() + commands + "\r\n");
            }
        });
        Button help = createHelpButton();
        HBox controls = new HBox(6, playButton, help, settingsBox, penColorDropDown, languagesDropDown);
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
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(e.getMessage());
                    alert.setContentText("Invalid File. Check to see if the file exists");
                    alert.showAndWait();
                }
            }
        });
        return help;
    }

    private HBox displayUserDefined(){
        UserDefinedBox variables = new UserDefinedBox("Variables");
        UserDefinedBox commands = new UserDefinedBox("User Commands");
        HBox user = new HBox(15, variables, commands);
        return user;
    }

//    private Button createLoadButton(){
//        Button load = new Button("Load");
//        load.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("Load Previous Code");
//                File file = fileChooser.showOpenDialog(primaryStage);
//                TextReader textReader = new TextReader(file);
//                textEditor.setText(textReader.getText());
//            }
//        });
//        return load;
//    }

    //    private Button createSaveButton(){
//        Button save = new Button("Save");
//        save.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                FileChooser fileChooser = new FileChooser();
//                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
//                fileChooser.getExtensionFilters().add(extFilter);
//                File file = fileChooser.showSaveDialog(primaryStage);
//                if (file != null) {
//                    TextWriter textWriter = new TextWriter(file);
//                    textWriter.writeTextFile(textEditor.getText());
//                }
//            }
//        });
//        return save;
//    }
    /**
     * Start the program.
     */
    public static void main (String[] args) {launch(args);}
}
