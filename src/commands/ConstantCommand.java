package commands;
import backend.BackendManager;

public class ConstantCommand extends GeneralCommand{

    public ConstantCommand(BackendManager bm, double d){
        super(bm);
        myType = "Constant";
        myMaxChildren = 0;
        myVal = d;
        isReady = true;
    }

}
