package commands;

import backend.BackendManager;

public class CosineCommand extends GeneralCommand{

    public CosineCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 1;
        myType = "Cosine";
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double deg = childVals.get(0)*Math.PI/180;
        double cos = Math.cos(deg);
        myVal = cos;
    }
}
