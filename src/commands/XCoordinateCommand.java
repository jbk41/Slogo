package commands;

import backend.BackendManager;

public class XCoordinateCommand extends GeneralCommand{

    public XCoordinateCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("XCoordinate");
    }

    public void update() {
        checkParameterCount();
        setVal(getBM().getCurrentTurtle().getX());
    }
}
