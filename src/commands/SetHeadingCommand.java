package commands;

import backend.BackendManager;

public class SetHeadingCommand extends MovementCommand {

    public SetHeadingCommand(BackendManager bm){
        super(bm);
        myType = "SetHeading";
        myMaxChildren = 1;
    }

    @Override
    protected void update() {
        myBM.setHeading(myVal);
    }

}
