package commands;

import backend.BackendManager;

public class GreaterThanCommand extends BooleanCommand {

    public GreaterThanCommand(BackendManager bm){
        super(bm);
        myType = "GreaterThan";
        myMaxChildren = 2;
    }

    public GreaterThanCommand(GeneralCommand c){
        super(c);
    }
    protected boolean evaluate(double a, double b){
        return (a > b);
    }

}
