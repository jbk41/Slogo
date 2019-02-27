package commands;

import backend.BackendManager;

public abstract class BooleanCommand extends GeneralCommand {

    public BooleanCommand(BackendManager bm){
        myMaxChildren = 2;
    }

    @Override
    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double returnVal = 0;
        if (evaluate(childVals.get(0), childVals.get(1))){
            returnVal = 1;
        }
        myVal = returnVal;
    }

    protected abstract boolean evaluate(double a, double b);

}
