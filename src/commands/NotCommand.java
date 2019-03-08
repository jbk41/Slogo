package commands;

import backend.BackendManager;

public class NotCommand extends GeneralCommand {

    public NotCommand(BackendManager bm){
        super(bm);
        setType("Not");
        setMaxChildren(1);
    }

    public void execute() {
        checkParameterCount();
        double returnVal = 0;
        GeneralCommand child = getChildren().get(0);
        if (child.getVal() == 0) {
            returnVal = 1;
        }
        setVal(returnVal);
        makeReady();
    }
}
