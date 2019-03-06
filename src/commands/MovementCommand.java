package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public class MovementCommand extends GeneralCommand {

    public MovementCommand(BackendManager bm){
        super(bm);
    }


    @Override
    public void execute() {
        checkParameterCount();
        executeChildren();
        myVal = myChildren.get(0).getVal();
        TurtleCommand command = new TurtleCommand(this);
        //System.out.println("adding command");
        myBM.getCommandManager().addToList(command);
    }

    @Override
    public String toString() {
        return myType;
    }
}
