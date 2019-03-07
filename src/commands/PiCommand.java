package commands;

import backend.BackendManager;

public class PiCommand extends GeneralCommand{

    public PiCommand(BackendManager bm) {
        super(bm);
        myMaxChildren = 0;
        myType = "Pi";
        myVal = Math.PI;
    }
}
