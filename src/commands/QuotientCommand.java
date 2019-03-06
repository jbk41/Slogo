package commands;

import backend.BackendManager;

public class QuotientCommand extends GeneralCommand {

    public QuotientCommand(BackendManager bm){
        super(bm);
        myType = "Quotient";
        myMaxChildren = 2;
    }

    public QuotientCommand(GeneralCommand c){
        super(c);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double denominator = myChildren.get(1).getVal();
        if (denominator == 0){
            //TODO: throw visible by 0 error
        }
        myVal = myChildren.get(0).getVal()/denominator;
    }
}
