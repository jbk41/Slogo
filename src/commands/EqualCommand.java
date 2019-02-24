package commands;

public class EqualCommand extends BooleanCommand {

    public EqualCommand(){
        super();
        myType = "Equal";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a == b);
    }

}
