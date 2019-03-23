package commands;

import backend.BackendManager;

/**
 * Sets the heading of the turtle to its child.
 * @author Justin and Ale
 */
public class HeadingCommand extends GeneralCommand {

    public HeadingCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("HeadingCommand");
    }

    /**
     * Sets the active turtles' headings to deg.
     */
    public void update() {
        checkParameterCount();
        setVal(getBM().getCurrentTurtle().getDeg());
    }

}
