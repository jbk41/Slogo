package commands;

import backend.BackendManager;

/**
 * Makes all turtles go home.
 */
public class HomeCommand extends StatementCommand{

    public HomeCommand (BackendManager bm){
        super(bm);
        setType("Home");
        setMaxChildren(0);
    }

    /**
     * Makes all active turtles go home.
     */
    @Override
    public void update() {
        getBM().home();
    }
}
