package commands;

import backend.BackendManager;

import java.util.Set;

public class SetHeadingCommand extends MovementCommand {

    public SetHeadingCommand(BackendManager bm){
        super(bm);
        setType("SetHeading");
        setMaxChildren(1);
    }

    @Override
    protected void update() {
        getBM().setHeading(getVal());
    }

}
