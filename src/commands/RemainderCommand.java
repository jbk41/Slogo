package commands;

public class RemainderCommand extends GeneralCommand {

    public RemainderCommand(){
        super();
        myType = "Remainder";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        myVal = childVals.get(0) % childVals.get(1);
    }
}
