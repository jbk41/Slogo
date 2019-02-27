package commands;

public class ForwardCommand extends GeneralCommand {

    private double myVar;

    public ForwardCommand (){
        super();
        myType = "Forward";
        myMaxChildren = 1;
    }

    @Override
    public void execute(){
        checkParameterCount();
        myChildren.get(0).execute();

        GeneralCommand child = myChildren.get(0);
        try {
            myVal = getValFromChild(child);
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
            return;
        }
        System.out.println("Forward " + myVal);
        //makeReady();
    }

    public void prepare(){
        try {
            myVal = getValFromChild(myChildren.get(0));
        }
        catch (IllegalAccessError e){
            e.printStackTrace();
        }
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
