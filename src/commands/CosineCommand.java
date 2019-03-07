package commands;

import backend.BackendManager;

public class CosineCommand extends GeneralCommand{

    public CosineCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("Cosine");
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double deg = childVals.get(0)*Math.PI/180;
        double cos = Math.cos(deg);
        setVal(cos);
    }
}
