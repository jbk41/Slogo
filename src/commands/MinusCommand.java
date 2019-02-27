package commands;

import backend.BackendManager;

public class MinusCommand extends GeneralCommand{

    public MinusCommand(BackendManager bm) {
        super();
        myMaxChildren = 1;
        myType = "Minus";
    }
    public void execute(){
        checkParameterCount();
        executeChildren();
        GeneralCommand child = myChildren.get(0);
        var childVals = getChildrenValues();
        myVal = childVals.get(0)*-1.0;
    }
}
