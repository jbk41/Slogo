package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public class StatementCommand extends GeneralCommand {

    public BackendManager BM;

    public StatementCommand(BackendManager bm){
        super();
        BM = bm;
    }

    @Override
    public void execute() {
        var command = new TurtleCommand(this);
        BM.getCommandManager().addToList(command);
    }

    @Override
    public String toString(){
        return myType;
    }
}

