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

//        GeneralCommand child = myChildren.get(0);
////        try {
////            myVal = child.getVal();
////        } catch (IllegalArgumentException e) {
////            System.out.println(e);
////            return;
////        }
        myVal = myChildren.get(0).getVal();
        update();
    }


    protected abstract void update() ;

    @Override
    public String toString() {
        return myType;
    }
}
