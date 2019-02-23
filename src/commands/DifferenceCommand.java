package commands;

public class DifferenceCommand extends GeneralCommand {

    public DifferenceCommand(){
        super();
        myType = "Difference";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        double diff = 0;
        for (int i = 0; i < myChildren.size(); i ++){
            GeneralCommand child = myChildren.get(i);
            if (child instanceof ConstantCommand){
                ConstantCommand c = (ConstantCommand) child;
                if (i == 0)
                    diff += c.getVal();
                else
                    diff -= c.getVal();
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Difference accepts constant nodes)");
            }
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(diff));
        makeDone();
    }
}
