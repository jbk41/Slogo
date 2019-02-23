package commands;

public class ForwardCommand extends GeneralCommand {

    private double myVar;

    public ForwardCommand (){
        super();
        myType = "Forward";
        myMaxChildren = 1;
    }

    public void execute() throws IllegalArgumentException{
        checkParameterCount();

        GeneralCommand child = myChildren.get(0);
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            myVar = c.getVal();
            myChildren.clear();
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Sum accepts Constants)");
        }
        makeDone();
    }

    public double getVar(){
        return myVar;
    }
}
