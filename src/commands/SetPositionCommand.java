package commands;

import backend.BackendManager;

public class SetPositionCommand extends MovementCommand {
    public SetPositionCommand(BackendManager bm) {
        super(bm);
        myMaxChildren = 2;
        myType = "SetTowards";

    }

    @Override
    protected void update() {
        myBM.setPosition(myChildren.get(0).getVal(), myChildren.get(1).getVal());
    }
}
