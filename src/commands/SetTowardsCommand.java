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

    public SetTowardsCommand(GeneralCommand c){
        super(c);
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

    protected void update() {
        myBM.setTowards(myChildren.get(0).getVal(), myChildren.get(1).getVal());
    }
}
