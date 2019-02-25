package commands;

public class ForwardCommand extends GeneralCommand {

    private double myVar;

    public ForwardCommand (){
        super();
        myType = "Forward";
        myMaxChildren = 1;

    }

    public void execute(){
        checkParameterCount();

        GeneralCommand child = myChildren.get(0);
        try {
            myVal = getValFromChild(child);
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
            return;
        }
        makeReady();
    }

    @Override
    public String toString(){
        return myType + ": " + Double.toString(myVal);
    }
    public ForwardCommand getCommand(GeneralCommand command){
        ForwardCommand new_Command = (ForwardCommand) command;
        return new_Command;
    }
}
