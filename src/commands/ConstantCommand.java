package commands;

public class ConstantCommand extends GeneralCommand{

    protected double myVal;

    public ConstantCommand(double d){
        super();
        myType = "Constant";
        myMaxChildren = 0;
        myVal = d;
        isReady = true;
    }

    public double getVal(){
        return myVal;
    }

}
