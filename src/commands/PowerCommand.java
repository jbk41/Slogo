package commands;

public class PowerCommand extends GeneralCommand {

    public PowerCommand(){
        super();
        myType = "Power";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        double val = 1;
        for (int i = 0; i < myChildren.size(); i ++){
            GeneralCommand child = myChildren.get(i);
            if (child instanceof ConstantCommand){
                ConstantCommand c = (ConstantCommand) child;
                if (i == 0) val *= c.getVal();
                else val = Math.pow(val, c.getVal());
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Difference accepts constant nodes)");
            }
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(val));
        makeDone();
    }


}
