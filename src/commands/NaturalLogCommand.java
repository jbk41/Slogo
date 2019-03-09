package commands;

import backend.BackendManager;

public class NaturalLogCommand extends GeneralCommand{

    final int INDEX = 0;
    public NaturalLogCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("NaturalLog");

    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        setVal(Math.log(childVals.get(INDEX)));
    }
}
