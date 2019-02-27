package commands;

import TurtleState.TurtleCommand;
import backend.CommandManager;
import backend.VariableManager;

public class MovementCommand extends GeneralCommand {
    public CommandManager CM;
    public VariableManager VM;

    public MovementCommand(CommandManager cm, VariableManager vm){
        CM = cm;
        VM = vm;
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
        CM.addToList(command);
    }


    @Override
    public String toString(){
        return myType + ": " + myVal;
    }
}


//    public void prepare(){
//        try {
//            myVal = getValFromChild(myChildren.get(0));
//        }
//        catch (IllegalAccessError e){
//            e.printStackTrace();
//        }
//    }
