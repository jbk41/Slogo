package commands;

import backend.BackendManager;

/**
 * Less than command.
 * @author Justin
 */
public class LessThanCommand extends BooleanCommand {

    public LessThanCommand(BackendManager bm){
        super(bm);
        setType("LessThan");
        setMaxChildren(2);
    }

    /**
     * Returns true if a < b.
     * @param a
     * @param b
     * @return
     */
    protected boolean evaluate(double a, double b){
        return (a < b);
    }

}
