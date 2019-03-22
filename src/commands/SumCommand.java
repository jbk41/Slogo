package commands;

import backend.BackendManager;
import java.util.ArrayList;

public class SumCommand extends GeneralCommand {

    public SumCommand(BackendManager bm) {
        super(bm);
        setType("Sum");
        setMaxChildren(2);
    }

    /**
     * Executes the command: Sets val to the addition of input 1 and 2's values.
     */
    @Override
    public void execute() throws IllegalArgumentException {
        checkParameterCount();
        executeChildren();
        ArrayList<Double> myChildrenVals = getChildrenValues();
        double sum = 0;
        for (double val : myChildrenVals) {
            sum += val;
        }
        setVal(sum);
    }
}
