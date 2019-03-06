package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

public class MovementCommand extends GeneralCommand {

    public MovementCommand(BackendManager bm){
        super(bm);
    }


    @Override
    public void execute() {
        checkParameterCount();
        executeChildren();
        myVal = myChildren.get(0).getVal();
        update();

        TurtleCommand command = new TurtleCommand(this);
<<<<<<< HEAD
        //System.out.println("adding command");
=======
>>>>>>> d64a2993ba87f1b8729be0299c7f21b421516941
        myBM.getCommandManager().addToList(command);
    }


    private void update(){

    }

    @Override
    public String toString() {
        return myType;
    }
}
