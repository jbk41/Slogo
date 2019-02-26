package commands;

public class ArcTangentCommand extends GeneralCommand{

    public ArcTangentCommand(){
        super();
        myMaxChildren = 1;
        myType = "ArcTangent";
    }

    @Override
    public void execute() throws IllegalArgumentException {
        checkParameterCount();
        executeChildren();
        var myVals = getChildrenValues();
        double val = myVals.get(0);
        double deg = val*Math.PI/180;
        double atan = Math.atan(deg);
        myVal = atan;
    }
}
