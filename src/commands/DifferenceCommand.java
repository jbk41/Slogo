package commands;

import backend.BackendManager;

/**
 * Difference command.
 * @author Justin and Ale
 */
public class DifferenceCommand extends GeneralCommand {

    public DifferenceCommand(BackendManager bm){
        super(bm);
        setType("Difference");
        setMaxChildren(2);
    }

    /**
     * Sets its value to its first child minus its second child.
     */
    public void execute(){
        checkParameterCount();
        executeChildren();
        double diff = 0;
        var childVals = getChildrenValues();
        diff += childVals.get(0);
        diff -= childVals.get(1);
        setVal(diff);
    }
}
