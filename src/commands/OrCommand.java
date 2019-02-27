package commands;

import backend.BackendManager;

public class OrCommand extends BooleanCommand {

    public OrCommand(BackendManager bm){
        super(bm);
        myType = "Or";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a >= 0 || b >= 0);
    }

}
