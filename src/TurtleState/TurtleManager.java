package TurtleState;

import backend.BackendManager;
import backend.CommandManager;

import java.util.ArrayList;

public class TurtleManager {

    private TurtleState myTS;
    private CommandManager myCM;
    private double myX = 0.0;
    private double myY = 0.0;
    private double myDeg = 0.0;
    private boolean penDown = false;
    private boolean showTurtle = true;
    private double myID;
    public ArrayList<TurtleState> myCommands;

    public TurtleManager(CommandManager manager){
        myCM = manager;
        myCommands = updateTurtle();
    }

    /**
     * Returns the list of raw commands based on previous state of turtle.
     */
    public ArrayList<TurtleState> getCommands() {
        return myCommands;
    }

    private ArrayList<TurtleState> updateTurtle(){
        var rawCommands = new ArrayList<TurtleState>();
        for (TurtleCommand command : myCM.getCommandList()){
            var newState =createTurtleState(command);
            rawCommands.add(newState);
        }
        return rawCommands;
    }

    private TurtleState createTurtleState(TurtleCommand command) { //FIXME: Check trig!
        myDeg += command.getDegrees();
        myX += command.getDisplacement()*Math.sin(myDeg* Math.PI/180);
        myY += command.getDisplacement()*Math.cos(myDeg* Math.PI/180);
        penDown = command.getPenDown();
        showTurtle = command.getVisible();
        return new TurtleState(myX, myY, myDeg, penDown, showTurtle, myID);
    }





}
