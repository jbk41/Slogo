package commands;

import backend.BackendManager;

/**
 * Clears the screen.
 * @author Justin and Ale
 */
public class ClearScreenCommand extends StatementCommand {

    public ClearScreenCommand(BackendManager bm){
        super(bm);
        setType("ClearScreen");
        setMaxChildren(0);
    }

    /**
     * Removes everything from the screen and resets the turtles.
     */
    @Override
    public void update() {
        checkParameterCount();
        getBM().clearScreen();
    }
}
