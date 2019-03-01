package commands;

import TurtleState.TurtleCommand;
import backend.BackendManager;

import java.security.InvalidKeyException;

public class MakeVariableCommand extends GeneralCommand {

    private BackendManager myBM;
    public String myKey;
    public double myValue;

    public MakeVariableCommand(BackendManager bm){
        super();
        myBM = bm;
        myType = "MakeVariable";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        try {
            myKey = myChildren.get(0).getVarName();
            myValue = myChildren.get(1).getVal();
            myBM.getVariableManager().getVariableMap().put(myKey, myValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
