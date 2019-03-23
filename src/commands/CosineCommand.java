package commands;

import backend.BackendManager;

/**
 * Calculates the cosine value of its child.
 * @author Justin and Ale
 */
public class CosineCommand extends GeneralCommand{

    public CosineCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("Cosine");
    }

    /**
     * Sets its own value to the value of the cosine of its child.
     */
    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double deg = childVals.get(0)*Math.PI/180;
        double cos = Math.cos(deg);
        setVal(cos);
    }
}
