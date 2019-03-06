package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public abstract class MovementCommand extends GeneralCommand {

    public MovementCommand(BackendManager bm){
        super(bm);
    }


    @Override
    public void execute() {
        checkParameterCount();
        executeChildren();
        myVal = myChildren.get(0).getVal();
        update();
<<<<<<< HEAD

        TurtleCommand command = new TurtleCommand(this);
        //System.out.println("adding command");
        myBM.getCommandManager().addToList(command);
=======
>>>>>>> 5c4c9edd7d778d7cb700690adec99d2936d20f36
    }


    protected abstract void update() ;

    @Override
    public String toString() {
        return myType;
    }
}
