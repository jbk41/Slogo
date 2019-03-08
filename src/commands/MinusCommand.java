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
        GeneralCommand child1 = getChildren().get(0);
        GeneralCommand child2 = getChildren().get(1);
        setVal(child1.getVal() - child2.getVal());
    }
}
