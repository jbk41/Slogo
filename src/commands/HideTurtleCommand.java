package commands;

import backend.BackendManager;

/**
 * Hides all turtles.
 * @author Justin and Ale
 */
public class HideTurtleCommand extends StatementCommand {

    public HideTurtleCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("HideTurtle");
        setVal(0);
        makeReady();
    }

    /**
     * Hides all active turtles.
     */
    @Override
    public void update() {
        getBM().hideTurtle();
    }
}
