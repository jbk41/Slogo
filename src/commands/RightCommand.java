package commands;

public class RightCommand extends GeneralCommand {

    public RightCommand (){
        super();
        myType = "Right";
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
            throw new IllegalArgumentException("Illegal Argument Type (Right accepts Constants)");
        }
        makeDone();
    }

}
