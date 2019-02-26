package commands;

public class DifferenceCommand extends GeneralCommand {

    public DifferenceCommand(){
        super();
        myType = "Difference";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double diff = 0;
        var childVals = getChildrenValues();
        diff += childVals.get(0);
        diff -= childVals.get(1);
        myVal = diff;
    }
}
