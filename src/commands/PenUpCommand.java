package commands;

import backend.BackendManager;

public class PenUpCommand extends GeneralCommand {

    public PenUpCommand(BackendManager bm) {
        makeReady();
        myMaxChildren = 0;
        myType = "PenUp";
    }
}
