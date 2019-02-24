package commands;

public class OrCommand extends BooleanCommand {

    public OrCommand(){
        super();
        myType = "Or";
        myMaxChildren = 2;
    }

    protected boolean evaluate(double a, double b){
        return (a >= 0 || b >= 0);
    }

}
