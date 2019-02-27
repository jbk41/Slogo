package commands;

import backend.CommandManager;
import backend.VariableManager;

public class RightCommand extends MovementCommand {

    public RightCommand (CommandManager cm, VariableManager vm){
        super(cm, vm);
        CM = cm;
        VM = vm;
        myType = "Right";
        myMaxChildren = 1;
    }

}
