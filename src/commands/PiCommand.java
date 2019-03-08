package commands;

import backend.BackendManager;

public class PiCommand extends GeneralCommand{

    public PiCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("Pi");
        setVal(Math.PI);
    }
}
