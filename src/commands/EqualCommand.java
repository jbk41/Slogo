package commands;

import backend.BackendManager;

public class EqualCommand extends BooleanCommand {

    public EqualCommand(BackendManager bm){
        super(bm);
        myType = "Equal";
        myMaxChildren = 2;
    }

    public EqualCommand(GeneralCommand c){
        super(c);
    }
    protected boolean evaluate(double a, double b){
        return (a == b);
    }

}
