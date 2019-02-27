package commands;

import backend.BackendManager;

public class PenDownCommand extends GeneralCommand{

    public PenDownCommand(BackendManager bm) {
        myMaxChildren = 0;
        makeReady();
        myType = "PenDown";
    }
}
