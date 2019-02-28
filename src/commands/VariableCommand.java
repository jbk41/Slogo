package commands;

import backend.BackendManager;

import java.security.InvalidKeyException;

public class VariableCommand extends GeneralCommand{

    public String myName;
    public BackendManager myBM;

    public VariableCommand(BackendManager manager, String name){
        super();
        myBM = manager;
        myType = "Variable";
        myMaxChildren = 0;
        myName = name;
        //makeReady(); // variables should be ready upon initialization
    }

    public void execute() {
        if (!myParent.toString().equals("MakeVariable")) {
            myVal = myBM.getVariableManager().getVariableMap().get(myName);
        }
    }

    public String getVar() {
        try {
            return myName;
        }
        catch(Exception e) {
            System.out.println("The Command you are trying to access is not a Variable");
        }
        return "";
    }
}
