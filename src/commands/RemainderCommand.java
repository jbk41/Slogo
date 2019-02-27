package commands;

import backend.BackendManager;

public class RemainderCommand extends GeneralCommand {

    public RemainderCommand(BackendManager bm){
        super();
        myType = "Remainder";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        myVal = childVals.get(0) % childVals.get(1);
    }
}
