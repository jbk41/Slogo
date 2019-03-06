package commands;

import backend.BackendManager;

public class SetTowardsCommand extends MovementCommand {

    public SetTowardsCommand (BackendManager bm) {
        super(bm);
        myMaxChildren = 1;
        myType = "SetTowards";
    }

    @Override
    protected void update() {
        myBM.setTowards(myChildren.get(0).getVal(), myChildren.get(1).getVal());
    }
}
