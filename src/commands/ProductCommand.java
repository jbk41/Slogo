package commands;

import backend.BackendManager;

public class ProductCommand extends GeneralCommand {

    public ProductCommand(BackendManager bm){
        super(bm);
        //isFull = false;
        setType("Product");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        setVal(getChildren().get(0).getVal() * getChildren().get(1).getVal());
    }
}
