package commands;

import backend.BackendManager;

public class PowerCommand extends GeneralCommand {

    public PowerCommand(BackendManager bm){
        super(bm);
        setType("Power");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        setVal(Math.pow(getChildren().get(0).getVal(), getChildren().get(1).getVal()));
    }
}
