//package Visualization;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import TurtleState.TurtleState;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PlayTurtle extends Button {
//    private List<TurtleState> trialTurtleMovement = new ArrayList<>();
//    public PlayTurtle(Turtle turtle, String label){
//        super(label);
//        // trial data
//        TurtleState turtle1 = new TurtleState(10, 10, 80, 0);
//        turtle1.setVisibility(true);
//        TurtleState turtle2 = new TurtleState(20, 20, 80, 0);
//        turtle2.setPenState(true);
//        TurtleState turtle3 = new TurtleState(30, 30, 80, 0);
//        turtle3.setVisibility(true);
//        turtle3.setPenState(true);
//        TurtleState turtle4 = new TurtleState(20, 20, 80, 0);
//        turtle4.setVisibility(true);
//        TurtleState turtle5 = new TurtleState(800, 20, 90, 0);
//        TurtleState turtle6 = new TurtleState(20, 20, 90, 0);
//        turtle6.setVisibility(true);
//        TurtleState turtle7 = new TurtleState(70, 70, 90, 0);
//        TurtleState turtle8 = new TurtleState(80, 80, 90, 0);
//        TurtleState turtle9 = new TurtleState(90, 90, 90, 0);
//        TurtleState turtle10 = new TurtleState(100, 100, 0, 0);
//        TurtleState turtle11 = new TurtleState(110, 110, 0, 0);
//
//        trialTurtleMovement.add(turtle1);
//        trialTurtleMovement.add(turtle2);
//        trialTurtleMovement.add(turtle3);
//        trialTurtleMovement.add(turtle4);
//        trialTurtleMovement.add(turtle5);
//        trialTurtleMovement.add(turtle6);
//        trialTurtleMovement.add(turtle7);
//        trialTurtleMovement.add(turtle8);
//        trialTurtleMovement.add(turtle9);
//        trialTurtleMovement.add(turtle10);
//        trialTurtleMovement.add(turtle11);
//
//        setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //
//                turtle.moveTurtle(trialTurtleMovement);
//                //TODO: we now take in Turtle States
//            }
//        });
//    }
//    public String getConsoleText(){
//        return "";
//    }
//}
