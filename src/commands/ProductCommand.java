package commands;

import backend.BackendManager;

public class ProductCommand extends GeneralCommand {

    public ProductCommand(BackendManager bm){
        super();
        //isFull = false;
        myType = "Product";
        myMaxChildren = 2;
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        myVal = childVals.get(0) * childVals.get(1);
    }
}
