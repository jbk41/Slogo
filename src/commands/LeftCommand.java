package commands;

public class LeftCommand extends GeneralCommand {

    public LeftCommand (){
        super();
        myType = "Left";
        myMaxChildren = 1;
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
            throw new IllegalArgumentException("Illegal Argument Type (Left accepts Constants)");
        }
        makeDone();
    }

}
