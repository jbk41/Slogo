package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public abstract class StatementCommand extends GeneralCommand {


    public StatementCommand(BackendManager bm){
        super(bm);
    }

    public StatementCommand(GeneralCommand c){
        super(c);
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

