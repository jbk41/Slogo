package Visualization;

import backend.BackendModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import TurtleState.TurtleState;

import java.util.ArrayList;
import java.util.List;

public class PlayTurtle extends Button {
    private List<TurtleState> trialTurtleMovement;
    public PlayTurtle(Turtle turtle, String label, TextEditor textEditor){
        super(label);
        String commands = textEditor.getText();
        System.out.println(commands);
        BackendModel backend = new BackendModel();
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //
                System.out.println(commands);
                backend.setLanguage("English");
                backend.interpret(commands);
                trialTurtleMovement = backend.getCommands();
                turtle.moveTurtle(trialTurtleMovement);
            }
        });
    }
    public String getConsoleText(){
        return "";
    }
}
