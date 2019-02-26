package commands;
import backend.VariableManager;

import java.security.InvalidKeyException;

public class VariableCommand extends GeneralCommand{

    private String myName;
    private VariableManager myVM;

    public VariableCommand(String name){
        super();
        //isFull = true;
        myType = "Variable";
        myMaxChildren = 0;
        myName = name;
        //makeReady(); // variables should be ready upon initialization
    }

    public void execute(){
        try {
            myVal = myVM.getValue(myName);
        }
        catch (InvalidKeyException e){
            return;
        }
    }

    public void setVariableManager(VariableManager vm){
        myVM = vm;
    }

    public String getName(){
        return myName;
    }

}
