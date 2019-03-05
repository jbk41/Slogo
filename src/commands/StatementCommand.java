package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public class StatementCommand extends GeneralCommand {


    public StatementCommand(BackendManager bm){
        super(bm);
    }

    @Override
    public void execute() {
        var command = new TurtleCommand(this);
        myBM.getCommandManager().addToList(command);
    }

    @Override
    public String toString(){
        return myType;
    }
}

