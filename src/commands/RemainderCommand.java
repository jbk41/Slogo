package commands;

import backend.BackendManager;

public class RemainderCommand extends GeneralCommand {

    final int NUM_INDEX = 0;
    final int DEM_INDEX = 1;

    final String DIVIDE_BY_ZERO = "Cannot divide by zero";

    public RemainderCommand(BackendManager bm){
        super(bm);
        setType("Remainder");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double modded = getChildren().get(DEM_INDEX).getVal();
        if (modded == 0){
            getBM().throwError(DIVIDE_BY_ZERO, getLineNumber());
            //TODO: throw divide by 0 error
        }
        setVal(getChildren().get(NUM_INDEX).getVal() % modded);
    }
}
