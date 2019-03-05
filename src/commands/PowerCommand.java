package commands;

import backend.BackendManager;

public class PowerCommand extends GeneralCommand {

    public PowerCommand(BackendManager bm){
        super(bm);
        myType = "Power";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();

        myVal = Math.pow(myChildren.get(0).getVal(), myChildren.get(1).getVal());
    }
}
