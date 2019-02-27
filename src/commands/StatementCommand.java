package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public class StatementCommand extends GeneralCommand {

    public StatementCommand(BackendManager bm){
        var command = new TurtleCommand(this);
        bm.getCommandManager().addToList(command);
    }

    @Override
    public String toString(){
        return myType + ": " + myVal;
    }
}

