package commands;

public class QuotientCommand extends GeneralCommand {

    public QuotientCommand(){
        super();
        myType = "Quotient";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        int quot = 1;
        for (int i = 0; i < myChildren.size(); i ++){
            GeneralCommand child = myChildren.get(i);
            if (child instanceof ConstantCommand){
                ConstantCommand c = (ConstantCommand) child;
                if (i == 0)
                    quot *= c.getVal();
                else
                    quot *= 1/c.getVal();
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Quotient accepts Constant nodes)");
            }
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(quot));
        makeDone();
    }
}
