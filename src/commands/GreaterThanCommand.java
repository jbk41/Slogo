package commands;

import backend.BackendManager;

/**
 * Greater than boolean command.
 * @author Justin and Ale
 */
public class GreaterThanCommand extends BooleanCommand {

    public GreaterThanCommand(BackendManager bm){
        super(bm);
        setType("GreaterThan");
        setMaxChildren(2);
    }

    /**
     * Returns true if a > b.
     * @param a
     * @param b
     * @return
     */
    public boolean evaluate(double a, double b){
        return (a > b);
    }

}
