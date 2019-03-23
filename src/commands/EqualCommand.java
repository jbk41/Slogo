package commands;

import backend.BackendManager;

/**
 * Equal command.
 * @author Justin and Ale
 */
public class EqualCommand extends BooleanCommand {

    public EqualCommand(BackendManager bm){
        super(bm);
        setType("Equal");
        setMaxChildren(2);
    }

    /**
     * Returns true if a == b.
     * @param a
     * @param b
     * @return
     */
    protected boolean evaluate(double a, double b){
        return (a == b);
    }

}
