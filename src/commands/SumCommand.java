package commands;

import backend.BackendManager;

public class SumCommand extends GeneralCommand {

    public SumCommand(BackendManager bm) {
        super();
        myType = "Sum";
        myMaxChildren = 2;
    }

    @Override
    public void execute() throws IllegalArgumentException {
        checkParameterCount();
        for (int i = 0; i < myMaxChildren; i++) {
            myChildren.get(i).execute();
        }
        var myChildrenVals = getChildrenValues();
        for (double val : myChildrenVals) {
            myVal += val;
        }
    }
}
