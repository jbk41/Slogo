package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class BackwardCommand extends MovementCommand {

    public BackwardCommand (BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("Backward");
    }


    @Override
    protected void update() { getBM().backward(getVal());
    }
}
