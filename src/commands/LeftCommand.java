package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;
import commands.MovementCommand;

public class LeftCommand extends MovementCommand {


    public LeftCommand (BackendManager bm){
        super(bm);
        myType = "Left";
        myMaxChildren = 1;
    }

    @Override
    protected void update() {
        myBM.left(myVal);
    }
}
