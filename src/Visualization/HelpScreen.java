package Visualization;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelpScreen {
    private HelpScreen(){

    }

    static void displayHelpScreen() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Help");
        ScrollPane root = new ScrollPane();
        stage.setScene(new Scene(root,750,500));
        try {
            String text = new String(Files.readAllBytes(Paths.get("data/CommandInstructions.txt")));
            Text txt = new Text(text);
            txt.setWrappingWidth(700);
            root.setContent(new Label("Turtle Instructions"));
            root.setContent(txt);
        } catch (IOException e){
            e.printStackTrace();
        }
        stage.show();
    }
}
