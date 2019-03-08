package commands;

import backend.BackendManager;

public class HeadingCommand extends GeneralCommand {

    public HeadingCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("HeadingCommand");
    }

    public void update() {
        checkParameterCount();
        setVal(getBM().getCurrentTurtle().getDeg());
    }

}
