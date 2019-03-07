package commands;

import backend.BackendManager;

public class AndCommand extends BooleanCommand {

    public AndCommand(BackendManager bm){
        super(bm);
        setType("And");
        setMaxChildren(2);
    }

    protected boolean evaluate(double a, double b){ return (a >= 0 && b >= 0);
    }

}
