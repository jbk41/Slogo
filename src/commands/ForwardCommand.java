package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class ForwardCommand extends MovementCommand {

    public ForwardCommand (BackendManager bm){
        super(bm);
        myType = "Forward";
        myMaxChildren = 1;
    }

    @Override
    private void update(){
        myBM.forward(myVal);
    }
}
