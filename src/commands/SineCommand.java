package commands;

public class SineCommand extends GeneralCommand{

    public SineCommand(){
        super();
        myMaxChildren = 1;
        myType = "Sine";
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double sine;
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            double deg = c.getVal()*Math.PI/180;
            sine = Math.sin(deg);
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Random accepts Constant nodes)");
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(sine));
        makeDone();
    }

}
