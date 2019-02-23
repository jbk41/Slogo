package commands;

public class BackwardCommand extends GeneralCommand {

    public BackwardCommand() {
        super();
        myMaxChildren = 1;
        myType = "Backward";
    }

    public void execute() throws IllegalArgumentException{
        checkParameterCount();

        GeneralCommand child = myChildren.get(0);
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            this.myVar = c.getVal();
            myChildren.clear();
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Backward accepts Constants)");
        }
        makeDone();
    }
}
