package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class LeftCommand extends MovementCommand {


    public LeftCommand (BackendManager bm){
        super(bm);
        myType = "Left";
        myMaxChildren = 1;
    }
}
