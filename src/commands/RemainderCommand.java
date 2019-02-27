package commands;

public class RemainderCommand extends GeneralCommand {

    public RemainderCommand(){
        super();
        myType = "Remainder";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        double rem = 1;
        for (int i = 0; i < myChildren.size(); i ++){
            GeneralCommand child = myChildren.get(i);
            if (child instanceof ConstantCommand){
                ConstantCommand c = (ConstantCommand) child;
                if (i == 0)
                    rem *= c.getVal();
                else
                    rem = rem % c.getVal();
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Remainder accepts Constant nodes)");
            }
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(rem));
        makeReady();
    }
}
