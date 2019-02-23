package commands;

public class LessThanCommand extends GeneralCommand {

    public LessThanCommand(){
        super();
        myType = "LessThan";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a < b);
    }

}
