package commands;

import backend.BackendManager;

/**
 * Command for getting the most recently active Turtle's ID.
 */
public class IDCommand extends GeneralCommand {


    public IDCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("ID");
    }

    /**
     * Gets the ID of the most recent turtle.
     */
    public void execute(){
        setVal(getBM().getCurrentTurtle().getID());
    }
}
