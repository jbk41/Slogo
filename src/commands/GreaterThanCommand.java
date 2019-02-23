package commands;

public class GreaterThanCommand extends BooleanCommand {

    public GreaterThanCommand(){
        super();
        myType = "GreaterThan";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a > b);
    }

}
