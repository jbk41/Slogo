package commands;

public class MinusCommand extends GeneralCommand{

    public MinusCommand() {
        super();
        myMaxChildren = 1;
        myType = "Minus";
    }
    public void execute(){
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double minus;
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            minus = c.getVal()*-1;
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Minus accepts Constant nodes)");
            }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(minus));
        makeReady();
    }
}
