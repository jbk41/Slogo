package commands;

import backend.BackendManager;

public class OrCommand extends BooleanCommand {

    public OrCommand(BackendManager bm){
        super(bm);
        setType("Or");
        setMaxChildren(2);
    }

    /**
     * Executes the command: returns true if a or b are greater than zero
     */
    protected boolean evaluate(double a, double b){
        return (a >= 0 || b >= 0);
    }

}
