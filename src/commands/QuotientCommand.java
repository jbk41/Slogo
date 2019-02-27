package commands;

import backend.BackendManager;

public class QuotientCommand extends GeneralCommand {

    public QuotientCommand(BackendManager bm){
        super();
        myType = "Quotient";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        myVal = childVals.get(0)/childVals.get(1);
    }
}
