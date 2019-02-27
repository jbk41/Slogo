package TurtleState;

import backend.BackendManager;
import backend.CommandManager;

import java.util.ArrayList;

public class TurtleManager {

    private TurtleState myTS;
    private CommandManager myCM;
    private double myX;
    private double myY;
    private double myDeg;
    private boolean penDown;
    private boolean showTurtle;
    private double myID;

    public TurtleManager(CommandManager commandManager){
        myCM = commandManager;
        updateTurtle();
        myTS = new TurtleState(myX, myY, myDeg, penDown, showTurtle, myID);
    }

    public TurtleState getState() {
        return myTS;
    }

    private void updateTurtle(){
        var rawCommands = new ArrayList<>();
        for (TurtleCommand command : myCM.getCommandList()){
            updateParams(command);
        }
    }

    private void updateParams(TurtleCommand command) { //FIXME: Check trig!
        myDeg += command.getDegrees();
        myX += command.getDisplacement()*Math.sin(myDeg* Math.PI/180);
        myY += command.getDisplacement()*Math.cos(myDeg* Math.PI/180);
        penDown = command.getPenDown();
        showTurtle = command.getVisible();
    }




}
