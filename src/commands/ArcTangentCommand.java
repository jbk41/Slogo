package commands;

import backend.BackendManager;

/**
 * Calculates the arctan of its child.
 * @author Justin and Ale
 */
public class ArcTangentCommand extends GeneralCommand{

    public ArcTangentCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("ArcTangent");
    }

    /**
     * Sets its value to the arctan of its child.
     * @throws IllegalArgumentException
     */
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
