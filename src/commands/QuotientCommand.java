package commands;

import backend.BackendManager;

public class QuotientCommand extends GeneralCommand {

    public QuotientCommand(BackendManager bm){
        super(bm);
        setType("Quotient");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double denominator = getChildren().get(1).getVal();
        if (denominator == 0){
            getBM().throwError("Divide by 0", getLineNumber());
            return;
        }
        setVal(getChildren().get(0).getVal()/denominator);
    }
}
