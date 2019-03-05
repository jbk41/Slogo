package commands;

import backend.BackendManager;
import java.util.ArrayList;

public class SumCommand extends GeneralCommand {

    public SumCommand(BackendManager bm) {
        super(bm);
        myType = "Sum";
        myMaxChildren = 2;
    }

    @Override
    public void execute() throws IllegalArgumentException {
        checkParameterCount();
        ArrayList<Double> myChildrenVals = getChildrenValues();
        for (double val : myChildrenVals) {
            myVal += val;
        }
    }
}
