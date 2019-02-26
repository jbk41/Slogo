package commands;

public class TangentCommand extends GeneralCommand{

    public TangentCommand(){
        super();
        myMaxChildren = 1;
        myType = "Tangent";
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double deg = childVals.get(0)*Math.PI/180;
        myVal = Math.tan(deg);
    }

}
