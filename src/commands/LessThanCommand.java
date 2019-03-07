package commands;

import backend.BackendManager;

public class LessThanCommand extends BooleanCommand {

    public LessThanCommand(BackendManager bm){
        super(bm);
        setType("LessThan");
        setMaxChildren(2);
    }

    protected boolean evaluate(double a, double b){
        return (a < b);
    }

}
