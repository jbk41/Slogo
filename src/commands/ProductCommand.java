package commands;

import backend.BackendManager;

public class ProductCommand extends GeneralCommand {

    public ProductCommand(BackendManager bm){
        super(bm);
        //isFull = false;
        myType = "Product";
        myMaxChildren = 2;
    }

    public ProductCommand(GeneralCommand c){
        super(c);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        myVal = myChildren.get(0).getVal() * myChildren.get(1).getVal();
    }
}
