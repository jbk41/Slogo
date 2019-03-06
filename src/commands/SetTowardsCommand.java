package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;
import TurtleState.TurtleCommand;

public class SetTowardsCommand extends MovementCommand {
    public SetTowardsCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 2;
        myType = "SetTowards";
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
}
