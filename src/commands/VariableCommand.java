package commands;

import backend.BackendManager;

import java.security.InvalidKeyException;

public class VariableCommand extends GeneralCommand{

    public String myName;

    public VariableCommand(BackendManager bm, String name){
        super(bm);
        myType = "Variable";
        myMaxChildren = 0;
        myName = name;
        //makeReady(); // variables should be ready upon initialization
    }

    public VariableCommand(GeneralCommand c){
        super(c);
        if (c instanceof VariableCommand){
            VariableCommand vc = (VariableCommand) c;
            myName = vc.getVarName();
        }
    }

    public void execute() {
        if(myBM.hasVariable(myName)) {
            myVal = myBM.getVariable(myName);
        }
        else {
            myVal = 0;
        }
    }

    public String getVarName() {
        return myName; }
}
