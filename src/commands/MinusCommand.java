package commands;

import backend.BackendManager;

public class MinusCommand extends GeneralCommand{

    final int FIRST_INDEX = 0;
    final int SECOND_INDEX = 1;

    public MinusCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(1);
        setType("Minus");
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        GeneralCommand child1 = getChildren().get(FIRST_INDEX);
        GeneralCommand child2 = getChildren().get(SECOND_INDEX);
        setVal(child1.getVal() - child2.getVal());
    }
}
