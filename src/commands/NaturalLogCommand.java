package commands;

public class NaturalLogCommand extends GeneralCommand{

    public NaturalLogCommand(){
        super();
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
