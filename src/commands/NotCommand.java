package commands;

public class NotCommand extends GeneralCommand {


    public NotCommand(){
        super();
        myType = "Not";
        myMaxChildren = 1;
    }

    public void execute(){
        checkParameterCount();
        double returnVal = 0;
        GeneralCommand child = myChildren.get(0);
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            if (c.getVal() == 0){
                returnVal = 1;
            }
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Product accepts constant arguments)");
        }

        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(returnVal));
        makeDone();
    }
}
