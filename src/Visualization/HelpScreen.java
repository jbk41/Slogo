package Visualization;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is used in essence as a utility class - we were told we couldn't have a static method so the implementation
 * was changed.  It displays a popup help screen that gives the users detailed instructions on all the commands
 * available to them. These instructions are in a text file in the /data folder called "CommandInstructions.txt", so it
 * is also easy to edit/add instruction explanations. One would simply create an object of the class and call
 * this method to display the help screen.  The user triggers this sequence when the help button is pressed.
 *
 * @author Bryant Huang, Mark Kang
 */
public class HelpScreen {

    void displayHelpScreen() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Help");
        ScrollPane root = new ScrollPane();
        stage.setScene(new Scene(root,750,500));
        String text = new String(Files.readAllBytes(Paths.get("data/CommandInstructions.txt")));
        Text txt = new Text(text);
        txt.setWrappingWidth(700);
        root.setContent(new Label("Turtle Instructions"));
        root.setContent(txt);
        stage.show();
    }
}
