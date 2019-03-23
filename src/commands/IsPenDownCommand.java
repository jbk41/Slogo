package commands;

import backend.BackendManager;

/**
 * Checks if the turtle has its pen down.
 * @author Justin
 */
public class IsPenDownCommand extends GeneralCommand {

    final int TRUE = 1;
    final int FALSE = 0;

    public IsPenDownCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsPenDown");
        makeReady();
    }

    /**
     * Sets its own value to 1 if the pen is up. Else 0.
     */
    public void execute(){
        if (getBM().getCurrentTurtle().getPenState()){
            setVal(TRUE);
        }
        else {
            setVal(FALSE);
        }
    }

}
