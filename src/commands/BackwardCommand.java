package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class BackwardCommand extends MovementCommand {

    public BackwardCommand (BackendManager bm){
        super(bm);
        myMaxChildren = 1;
        myType = "Backward";
    }

    @Override
    protected void update() {
        myBM.backward(myVal);
    }
}
