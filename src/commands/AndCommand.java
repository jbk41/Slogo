package commands;

public class AndCommand extends BooleanCommand {

    public AndCommand(){
        super();
        myType = "And";
        myMaxChildren = 2;
    }


    protected boolean evaluate(double a, double b){ return (a >= 0 && b >= 0);
    }

}
