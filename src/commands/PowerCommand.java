package commands;

public class PowerCommand extends GeneralCommand {

    public PowerCommand(){
        super();
        myType = "Power";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double val = childVals.get(0);
        myVal = Math.pow(val, childVals.get(1));
    }
}
