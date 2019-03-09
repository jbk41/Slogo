package commands;

import backend.BackendManager;

public class QuotientCommand extends GeneralCommand {

    final int DEN_INDEX = 1;
    final int NUM_INDEX = 0;

    public QuotientCommand(BackendManager bm){
        super(bm);
        setType("Quotient");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double denominator = getChildren().get(DEN_INDEX).getVal();
        if (denominator == 0){
            getBM().throwError("Divide by 0", getLineNumber());
            return;
        }
        setVal(getChildren().get(NUM_INDEX).getVal()/denominator);
    }
}
