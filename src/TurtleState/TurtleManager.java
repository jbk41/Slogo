package TurtleState;

import backend.BackendManager;
import backend.CommandManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TurtleManager {

    private TurtleState myTS;
    private CommandManager myCM;
    private String myType;
    private double myX ;
    private double myY ;
    private double myDeg ;
    private boolean penDown ;
    private boolean showTurtle ;
    private double myID;
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

    private TurtleState createTurtleState(TurtleCommand command) { //FIXME: Check trig!
        //myType = command.getType();
        myDeg += command.getDegrees();
        myX += command.getDisplacement()*Math.sin(myDeg* Math.PI/180);
        myY += command.getDisplacement()*Math.cos(myDeg* Math.PI/180);
        penDown = command.getPenDown();
        showTurtle = command.getVisible();
        return new TurtleState(myX, myY, myDeg, penDown, showTurtle, myID);
    }





}
