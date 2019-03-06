package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

import java.security.InvalidKeyException;

public class MakeVariableCommand extends GeneralCommand {

    public MakeVariableCommand(BackendManager bm){
        super(bm);
        myType = "MakeVariable";
        myMaxChildren = 2;
    }
    public MakeVariableCommand(GeneralCommand c){
        super(c);
    }

    public void execute(){
        executeChildren();
        checkParameterCount();
        try {
            String varName = "";
            if (myChildren.get(0) instanceof VariableCommand){
                VariableCommand vc = (VariableCommand) myChildren.get(0);
                varName = vc.getVarName();
            }
            else {
                //TODO: not a variable error
                return;
            }

            double val = myChildren.get(1).getVal();
            myBM.setVariable(varName, val);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
