package commands;

import backend.BackendManager;

/**
 * Stamps the current turtle
 * @author Justin
 */
public class ClearStampsCommand extends GeneralCommand{

    public ClearStampsCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("Stamp");
    }

    /**
     * clears all stamps
     */
    public void execute(){
        checkParameterCount();
        executeChildren();
        setVal(getBM().clearStamps());
    }
}
