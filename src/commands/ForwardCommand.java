package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class ForwardCommand extends MovementCommand {

    public ForwardCommand (BackendManager bm){
        super(bm);
        setType("Forward");
        setMaxChildren(1);
    }

    @Override
    public void update(){
        getBM().forward(getVal());
    }
}
