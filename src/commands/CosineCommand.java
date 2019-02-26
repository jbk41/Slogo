package commands;

public class CosineCommand extends GeneralCommand{

    public CosineCommand(){
        super();
        myMaxChildren = 1;
        myType = "Cosine";
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double deg = childVals.get(0)*Math.PI/180;
        double cos = Math.cos(deg);
        myVal = cos;
    }
}
