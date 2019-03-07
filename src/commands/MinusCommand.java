package commands;

import backend.BackendManager;

public class MinusCommand extends GeneralCommand{

    public MinusCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(1);
        setType("Minus");
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        GeneralCommand child = getChildren().get(0);
        var childVals = getChildrenValues();
        setVal(childVals.get(0)*-1.0);
    }
}
