package commands;

import backend.BackendManager;

public class YCoordinateCommand extends GeneralCommand {

    public YCoordinateCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("YCoordinateCommand");
    }

    /**
     * Updates the TurtleState: sets val to the current value of y. Meant for returning the current value of y to console
     */
    public void update() {
        checkParameterCount();
        setVal(getBM().getCurrentTurtle().getY());
    }
}
