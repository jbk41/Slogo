package Visualization;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class PlayTurtle extends Button {
    private int[][] trialTurtleMovement = new int [8][2];
    public PlayTurtle(TurtleDisplay turtleDisplay, String label){
        super(label);
        // trial data
        trialTurtleMovement[0] = new int[] {0, -10};
        trialTurtleMovement[1] = new int[] {0, -20};
        trialTurtleMovement[2] = new int[] {0, -10};
        trialTurtleMovement[3] = new int[] {0, -20};
        trialTurtleMovement[4] = new int[] {0, -5};
        trialTurtleMovement[5] = new int[] {0, -60};
        trialTurtleMovement[6] = new int[] {0, -5};
        trialTurtleMovement[7] = new int[] {0, -20};
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                turtleDisplay.moveTurtle(trialTurtleMovement);
            }
        });
    }
    public String getConsoleText(){
        return "";
    }
}
