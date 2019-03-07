package commands;

import backend.BackendManager;

public class TangentCommand extends GeneralCommand{

    public TangentCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("Tangent");
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double deg = childVals.get(0)*Math.PI/180;
        setVal(Math.tan(deg));
    }

}
