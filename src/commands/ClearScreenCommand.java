package commands;

import backend.BackendManager;

public class ClearScreenCommand extends StatementCommand {

    public ClearScreenCommand(BackendManager bm){
        super(bm);
        myType = "ClearScreen";
        myMaxChildren = 0;
    }
}
