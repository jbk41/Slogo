package commands;

import backend.BackendManager;

public class EqualCommand extends BooleanCommand {

    public EqualCommand(BackendManager bm){
        super(bm);
        myType = "Equal";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a == b);
    }

}
