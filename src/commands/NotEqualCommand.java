package commands;

import backend.BackendManager;

public class NotEqualCommand extends BooleanCommand{

    public NotEqualCommand(BackendManager bm){
        super(bm);
        setType("NotEqual");
        setMaxChildren(2);
    }

    /**
     * Evaluates the command: returns true if a > b, false if b > a
     */
    protected boolean evaluate(double a, double b){
        return (a > b);
    }

}
