package commands;

public class ArcTangentCommand extends GeneralCommand{

    public ArcTangentCommand(){
        super();
        myMaxChildren = 1;
        myType = "ArcTangent";
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double atan;
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            double deg = c.getVal()*Math.PI/180;
            atan = Math.atan(deg);
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (ArcTangent accepts Constant nodes)");
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(atan));
        makeDone();
    }

}
