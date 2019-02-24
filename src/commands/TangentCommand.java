package commands;

public class TangentCommand extends GeneralCommand{

    public TangentCommand(){
        super();
        myMaxChildren = 1;
        myType = "Tangent";
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double tan;
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            double deg = c.getVal()*Math.PI/180;
            tan = Math.tan(deg);
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Tangent accepts Constant nodes)");
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(tan));
        makeDone();
    }

}
