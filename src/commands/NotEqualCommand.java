package commands;

import backend.BackendManager;

public class NotEqualCommand extends BooleanCommand{

    public NotEqualCommand(BackendManager bm){
        super(bm);
        myType = "NotEqual";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a > b);
    }

}
