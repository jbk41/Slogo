package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public abstract class StatementCommand extends GeneralCommand {


    public StatementCommand(BackendManager bm){
        super(bm);
    }

    @Override
    public void execute() {
        update();
    }

    public abstract void update();

    @Override
    public String toString(){
        return myType;
    }
}

