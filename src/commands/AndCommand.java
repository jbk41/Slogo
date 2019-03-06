package commands;

import backend.BackendManager;

public class AndCommand extends BooleanCommand {

    public AndCommand(BackendManager bm){
        super(bm);
        myType = "And";
        myMaxChildren = 2;
    }

    public AndCommand(GeneralCommand c){
        super(c);
    }


    protected boolean evaluate(double a, double b){ return (a >= 0 && b >= 0);
    }

}
