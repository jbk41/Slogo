package commands;

import backend.BackendManager;

public class ProductCommand extends GeneralCommand {

    final int INDEX_0 = 0;
    final int INDEX_1 = 1;

    public ProductCommand(BackendManager bm){
        super(bm);
        //isFull = false;
        setType("Product");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        setVal(getChildren().get(INDEX_0).getVal() * getChildren().get(INDEX_1).getVal());
    }
}
