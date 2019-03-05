package commands;

import backend.BackendManager;

import java.security.InvalidKeyException;

public class VariableCommand extends GeneralCommand{

    public String myName;
    public BackendManager myBM;

    public VariableCommand(BackendManager bm, String name){
        super(bm);
        myType = "Variable";
        myMaxChildren = 0;
        myName = name;
        //makeReady(); // variables should be ready upon initialization
    }

    public void execute() {
        if(myBM.getVariableManager().getVariableMap().containsKey(myName)) {
            myVal = myBM.getVariableManager().getVariableMap().get(myName);
        }
        else {
            myVal = 0;
        }
    }

    public String getVarName() { return myName; }
}
