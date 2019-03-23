package commands;

import backend.BackendManager;

/**
 * Boolean And command. Sets value to 1 if both of its children are greater than 0.
 * @author Justin and Ale
 */
public class AndCommand extends BooleanCommand {

    public AndCommand(BackendManager bm){
        super(bm);
        setType("And");
        setMaxChildren(2);
    }

    @Override
    protected boolean evaluate(double a, double b){ return (a >= 0 && b >= 0);
    }

}
