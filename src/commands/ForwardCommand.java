package commands;

import backend.CommandManager;
import backend.VariableManager;

public class ForwardCommand extends MovementCommand {

    public ForwardCommand (CommandManager cm, VariableManager vm){
        super(cm ,vm);
        myType = "Forward";
        myMaxChildren = 1;
    }
}
