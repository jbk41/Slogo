package commands;

public class SineCommand extends GeneralCommand{

    public SineCommand(){
        super();
        myMaxChildren = 1;
        myType = "Sine";
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double deg = childVals.get(0)*Math.PI/180;
        myVal  = Math.sin(deg);
    }
}
