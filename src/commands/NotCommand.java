package commands;

import backend.BackendManager;

public class NotCommand extends GeneralCommand {

    final int INDEX = 0;
    final int TRUE = 1;
    final int FALSE = 0;

    public NotCommand(BackendManager bm){
        super(bm);
        setType("Not");
        setMaxChildren(1);
    }

    public void execute() {
        checkParameterCount();
        double returnVal = FALSE;
        GeneralCommand child = getChildren().get(INDEX);
        if (child.getVal() == 0) {
            returnVal = TRUE;
        }
        setVal(returnVal);
        makeReady();
    }
}
