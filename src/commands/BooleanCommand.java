package commands;

public abstract class BooleanCommand extends GeneralCommand {

    public BooleanCommand(){
        super();
        myMaxChildren = 2;
    }

    @Override
    public void execute() throws IllegalArgumentException{
        checkParameterCount();
        double[] d = new double[2];
        GeneralCommand child;
        for (int i = 0; i < myChildren.size(); i++){
            //System.out.println(child.getType());
            child = myChildren.get(i);
            if (child instanceof ConstantCommand){
                ConstantCommand c = (ConstantCommand) child;
                d[i] = c.getVal();
            }
            else {
                throw new IllegalArgumentException("Illegal Argument Type (Boolean commands accept constant arguments)");
            }
        }

        int index = getIndexOfCurrentInParent();
        double returnVal = 0;
        if (evaluate(d[0], d[1])){
            returnVal = 1;
        }
        myParent.getChildren().set(index, new ConstantCommand(returnVal));
        makeDone();
    }

    protected abstract boolean evaluate(double a, double b);

}
