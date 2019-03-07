package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;
import commands.MovementCommand;

public class LeftCommand extends MovementCommand {


    public LeftCommand (BackendManager bm){
        super(bm);
        setType("Left");
        setMaxChildren(1);
    }

    @Override
    protected void update() {
        getBM().left(getVal());
    }
}
