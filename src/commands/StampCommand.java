package commands;

import backend.BackendManager;

/**
 * Stamps the current turtle
 * @author Justin
 */
public class StampCommand extends GeneralCommand{

    public StampCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("Stamp");
    }

    /**
     * adds a copy of the current turtle of the stamp
     */
    public void execute(){
        checkParameterCount();
        executeChildren();
        getBM().addStampOfCurrentTurtle();
    }
}
