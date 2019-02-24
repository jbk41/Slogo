package commands;

public class ForwardCommand extends GeneralCommand {

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
            this.myVar = c.getVal();
            myChildren.clear();
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Forward accepts Constants)");
        }
        makeDone();
    }

    public ForwardCommand getCommand(GeneralCommand command){
        ForwardCommand new_Command = (ForwardCommand) command;
        return new_Command;
    }
}
