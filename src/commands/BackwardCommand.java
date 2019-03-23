package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

/**
 * Moves all turtles backward.
 * @author Justin and Ale
 */
public class BackwardCommand extends MovementCommand {

    public BackwardCommand (BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("Backward");
    }

    /**
     * Moves the active turtles backward
     */
    @Override
    protected void update() { getBM().backward(getVal());
    }
}
