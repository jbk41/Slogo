package commands;

public class ProductCommand extends GeneralCommand {

    public ProductCommand(){
        super();
        //isFull = false;
        myType = "Product";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        double prod = 1;
        for (GeneralCommand child: myChildren){
            if (child instanceof ConstantCommand){
                ConstantCommand c = (ConstantCommand) child;
                prod *= c.getVal();
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Product accepts constant arguments)");
            }
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(prod));
        makeDone();
    }
}
