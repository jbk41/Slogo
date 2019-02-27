package commands;

import backend.BackendManager;

public class GreaterThanCommand extends BooleanCommand {

    public GreaterThanCommand(BackendManager bm){
        super(bm);
        myType = "GreaterThan";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a > b);
    }

}
