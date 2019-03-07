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

    protected void update() {
        myBM.setTowards(myChildren.get(0).getVal(), myChildren.get(1).getVal());
    }
}
