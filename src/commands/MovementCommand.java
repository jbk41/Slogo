package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public class MovementCommand extends GeneralCommand {
    public BackendManager BM;

    public MovementCommand(BackendManager bm){
        super();
        BM = bm;
    }


    @Override
    public void execute() {
        checkParameterCount();
        executeChildren();

        GeneralCommand child = myChildren.get(0);
        try {
            myVal = child.getVal();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }
        var command = new TurtleCommand(this);
        BM.getCommandManager().addToList(command);
    }

    @Override
    public String toString() {
        return myType;
    }
}
