package commands;

import backend.CommandManager;
import backend.VariableManager;

public class BackwardCommand extends MovementCommand {

    public BackwardCommand (CommandManager cm, VariableManager vm){
        super(cm, vm);
        CM = cm;
        VM = vm;
        myMaxChildren = 1;
        myType = "Backward";
    }
}
