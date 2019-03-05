package commands;

import backend.BackendManager;

public class RemainderCommand extends GeneralCommand {

    public RemainderCommand(BackendManager bm){
        super(bm);
        myType = "Remainder";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double modded = myChildren.get(1).getVal();
        if (modded == 0){
            //TODO: throw divide by 0 error
        }
        myVal = myChildren.get(0).getVal() % modded;
    }
}
