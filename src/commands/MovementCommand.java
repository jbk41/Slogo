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

//        GeneralCommand child = myChildren.get(0);
////        try {
////            myVal = child.getVal();
////        } catch (IllegalArgumentException e) {
////            System.out.println(e);
////            return;
////        }
        TurtleCommand command = new TurtleCommand(this);
        myBM.getCommandManager().addToList(command);
    }

    @Override
    public String toString() {
        return myType;
    }
}
