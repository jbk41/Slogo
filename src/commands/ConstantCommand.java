package commands;

public class ConstantCommand extends GeneralCommand{

    private double myVal;

    public ConstantCommand(double d){
        super();
        //isFull = true;
        myType = "Constant";
        myMaxChildren = 0;
        myVal = d;
    }

    @Override
    public String getType(){
        return myVal + "";
    }
    public double getVal(){
        return myVal;
    }

    public void execute(){
        makeDone();
    }
}
