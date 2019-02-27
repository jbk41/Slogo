package commands;

import backend.BackendManager;

public class PenUpCommand extends StatementCommand {

    public PenUpCommand(BackendManager bm) {
        super(bm);
        makeReady();
        myMaxChildren = 0;
        myType = "PenUp";
        myVal = 0;
    }
}
