package commands;

import backend.BackendManager;

public class NaturalLogCommand extends GeneralCommand{

    public NaturalLogCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 1;
        myType = "NaturalLog";
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        myVal = Math.log(childVals.get(0));
    }
}
