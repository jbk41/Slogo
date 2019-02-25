package commands;

public class ConstantCommand extends GeneralCommand{

    protected double myVal;

    public ConstantCommand(double d){
        super();
        myType = "Constant";
        myMaxChildren = 0;
        myVal = d;
        makeReady(); // is immediately executable upon initialization
    }

    @Override
    public String toString(){
        return Double.toString(myVal);
    }

    public double getVal(){
        return myVal;
    }

    public void execute(){
        return;
    }
}
