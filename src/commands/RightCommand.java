package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class RightCommand extends MovementCommand {

    public RightCommand (BackendManager bm){
        super(bm);
        myType = "Right";
        myMaxChildren = 1;
    }

    public RightCommand(GeneralCommand c){
        super(c);
    }

    @Override
    protected void update() {
        myBM.right(myVal);
    }

}
