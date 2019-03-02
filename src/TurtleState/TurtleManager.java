package TurtleState;

import backend.CommandManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TurtleManager {

    private CommandManager myCM;
    private double myX ;
    private double myY ;
    private double myDeg ;
    private boolean penDown ;
    private boolean showTurtle ;
    private double myID;
    private boolean clear;
    public ArrayList<TurtleState> myCommands = new ArrayList<TurtleState>();

    public TurtleManager(CommandManager manager){
        myCM = manager;
        updateTurtle(myCommands);
        printCommands();
    }

    /**
     * Returns the list of raw commands based on previous state of turtle.
     */
    public ArrayList<TurtleState> getCommands() {
        return myCommands;
    }

    public void printCommands() {
        for (TurtleState state : myCommands) {
            System.out.println("X: " + state.getXPos());
            System.out.println("Y: " +state.getYPos());
            System.out.println("Deg: " +state.getMyDegrees());
            System.out.println("PD: " +state.getPenDown());
            System.out.println("Vis: " +state.getVisibility());
            System.out.println();
        }
    }

    private void updateTurtle(ArrayList<TurtleState> list){
        for (TurtleCommand command : myCM.getCommandList()){
            var newState = createTurtleState(command);
            list.add(newState);
        }
    }

    private TurtleState createTurtleState(TurtleCommand command) {
        clear = false;
        myDeg = setDegrees(command);
        myX += command.getDisplacement() * Math.sin(myDeg * Math.PI / 180);
        myY += command.getDisplacement() * Math.cos(myDeg * Math.PI / 180);
        penDown = setPen(command);
        showTurtle = command.getVisible();
        if (command.getType().equals("ClearScreen") || command.getType().equals("Home")) resetTurtle(command);
        return new TurtleState(myX, myY, myDeg, penDown, showTurtle, myID);
    }

    private boolean setPen(TurtleCommand command) {
        if (command.getPenDown()) penDown = true;
        return penDown;
    }

    private double setDegrees(TurtleCommand command) {
        if (command.getType().equals("SetHeading")) myDeg = command.getDegrees();
        else myDeg += command.getDegrees();
        return myDeg;
    }

    private void resetTurtle(TurtleCommand command) {
        myDeg = 0.0;
        myX = 0.0;
        myY = 0.0;
        penDown = false;
        showTurtle = true;
        clear = false;
        if (command.getType().equals("ClearScreen")) clear = true;
    }





}
