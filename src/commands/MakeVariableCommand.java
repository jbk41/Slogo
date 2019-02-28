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
        executeChildren();
        GeneralCommand child = myChildren.get(0);
        try {
            myKey = myChildren.get(0).getVarName();
            myValue = myChildren.get(1).getVal();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }
        myBM.getVariableManager().getVariableMap().get(myKey);
        myBM.getVariableManager().getVariableMap().put(myKey, myValue);
    }
}
