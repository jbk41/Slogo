package commands;

public class ForwardCommand extends MainTurtleCommand {

    private double myVar;

    public ForwardCommand (){
        super();
        myType = "Forward";
        myMaxChildren = 1;
    }
}
