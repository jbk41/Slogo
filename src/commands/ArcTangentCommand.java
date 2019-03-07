package commands;

import backend.BackendManager;

public class ArcTangentCommand extends GeneralCommand{

    public ArcTangentCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("ArcTangent");
    }

    @Override
    public void execute() throws IllegalArgumentException {
        checkParameterCount();
        executeChildren();
        var myVals = getChildrenValues();
        double val = myVals.get(0);
        double deg = val*Math.PI/180;
        double atan = Math.atan(deg);
        setVal(atan);
    }
}
