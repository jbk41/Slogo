package commands;

public class SumCommand extends GeneralCommand {

    public SumCommand(){
        super();
        myType = "Sum";
        myMaxChildren = 2;
    }

    @Override
    public void execute() throws IllegalArgumentException{
        checkParameterCount();
        int sum = 0;
        for (GeneralCommand child: myChildren){
            //System.out.println(child.getType());
            if (child instanceof ConstantCommand){
                ConstantCommand c = (ConstantCommand) child;
                sum += c.getVal();
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Sum accepts constant nodes)");
            }
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(sum));
        makeDone();
    }

    private int getIndexOfCurrentInParent(){
        return (myParent.getChildren().indexOf(this));
    }

}
