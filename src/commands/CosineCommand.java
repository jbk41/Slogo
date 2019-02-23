package commands;

public class CosineCommand extends GeneralCommand{

    public CosineCommand(){
        super();
        myMaxChildren = 1;
        myType = "Cosine";
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double cos;
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            double deg = c.getVal()*Math.PI/180;
            cos = Math.cos(deg);
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Cosine accepts Constant nodes)");
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(cos));
        makeDone();
    }

}
