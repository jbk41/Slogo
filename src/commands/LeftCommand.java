package commands;

import backend.CommandManager;
import backend.VariableManager;

public class LeftCommand extends MovementCommand {

    public CommandManager CM;
    public VariableManager VM;

    public LeftCommand (CommandManager cm, VariableManager vm){
        super(cm ,vm);
        myType = "Left";
        myMaxChildren = 1;
    }
}
