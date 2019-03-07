package commands;

import backend.BackendManager;

public class RemainderCommand extends GeneralCommand {

    public RemainderCommand(BackendManager bm){
        super(bm);
        setType("Remainder");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double modded = getChildren().get(1).getVal();
        if (modded == 0){
            //TODO: throw divide by 0 error
        }
        setVal(getChildren().get(0).getVal() % modded);
    }
}
