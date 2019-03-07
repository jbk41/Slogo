package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public abstract class MovementCommand extends GeneralCommand {

    public MovementCommand(BackendManager bm){
        super(bm);
    }


    public MovementCommand(GeneralCommand c){
        super(c);
    }
    @Override
    public void execute() {
        checkParameterCount();
        executeChildren();
        myVal = myChildren.get(0).getVal();
        update();
    }


    protected abstract void update();

    @Override
    public String toString() {
        return myType;
    }
}
