package commands;

import backend.BackendManager;

public class PowerCommand extends GeneralCommand {

    final int NUM_INDEX = 0;
    final int EXP_INDEX = 1;

    public PowerCommand(BackendManager bm){
        super(bm);
        setType("Power");
        setMaxChildren(2);
    }

    /**
     * Executes the command: sets the val to the first input's value raised to the power of the second input's value
     */
    public void execute(){
        checkParameterCount();
        executeChildren();
        setVal(Math.pow(getChildren().get(NUM_INDEX).getVal(), getChildren().get(EXP_INDEX).getVal()));
    }
}
