package commands;

import backend.BackendManager;

/**
 * Checks if the turtle is visible.
 * @author Justin
 */
public class IsShowingCommand extends GeneralCommand {

    final int TRUE = 1;
    final int FALSE = 0;

    public IsShowingCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsShowing");
        makeReady();
    }

    /**
     * Sets its value to 1 if it is visible. Else 0.
     */
    public void execute(){
        if (getBM().getCurrentTurtle().getVisibility()){
            setVal(TRUE);
        }
        else {
            setVal(FALSE);
        }

    }
}
