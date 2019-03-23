package commands;

import backend.BackendManager;

/**
 * Basic command for all booleans with two argument.
 * @author Justin and Ale
 */
public abstract class BooleanCommand extends GeneralCommand {

    public BooleanCommand(BackendManager bm){
        super(bm);
        setMaxChildren(2);
    }

    /**
     *
     */
    @Override
    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double returnVal = 0;
        if (evaluate(childVals.get(0), childVals.get(1))){
            returnVal = 1;
        }
        setVal(returnVal);
    }

    /**
     * Defines the actual boolean comparison between a and b.
     * @param a
     * @param b
     * @return
     */
    protected abstract boolean evaluate(double a, double b);

}
