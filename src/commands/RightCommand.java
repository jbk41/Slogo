package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class RightCommand extends MovementCommand {

    public RightCommand (BackendManager bm){
        super(bm);
        setType("Right");
        setMaxChildren(1);
    }

    @Override
    protected void update() {
        getBM().right(getVal());
    }
}
