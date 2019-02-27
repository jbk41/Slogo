package commands;

import backend.BackendManager;

public class LessThanCommand extends BooleanCommand {

    public LessThanCommand(BackendManager bm){
        super(bm);
        myType = "LessThan";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a < b);
    }

}
