package commands;

import backend.BackendManager;

public class OrCommand extends BooleanCommand {

    public OrCommand(BackendManager bm){
        super(bm);
        setType("Or");
        setMaxChildren(2);
    }

    protected boolean evaluate(double a, double b){
        return (a >= 0 || b >= 0);
    }

}
