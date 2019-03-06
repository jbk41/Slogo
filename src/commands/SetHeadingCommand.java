package commands;

import backend.BackendManager;

import java.util.Set;

public class SetHeadingCommand extends MovementCommand {

    public SetHeadingCommand(BackendManager bm){
        super(bm);
        myType = "SetHeading";
        myMaxChildren = 1;
    }

    public SetHeadingCommand(GeneralCommand c){
        super(c);
    }

    @Override
    protected void update() {
        myBM.setHeading(myVal);
    }

}
