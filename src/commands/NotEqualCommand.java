package commands;

public class NotEqualCommand extends BooleanCommand{

    public NotEqualCommand(){
        super();
        myType = "NotEqual";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a > b);
    }

}
