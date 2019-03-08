package commands;

import backend.BackendManager;

public class YCoordinateCommand extends GeneralCommand {

    public YCoordinateCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("YCoordinateCommand");
    }

    public void update() {
        checkParameterCount();
        setVal(getBM().getCurrentTurtle().getY());
    }
}
