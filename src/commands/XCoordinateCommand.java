package commands;

import backend.BackendManager;

public class XCoordinateCommand extends GeneralCommand{

    public XCoordinateCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("XCoordinate");
    }

    /**
     * Updates the TurtleState: sets val to the current value of x. Meant for returning the current value of x to console
     */
    public void update() {
        checkParameterCount();
        setVal(getBM().getCurrentTurtle().getX());
    }
}
