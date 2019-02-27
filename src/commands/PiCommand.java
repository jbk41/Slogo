package commands;

import backend.BackendManager;

public class PiCommand extends ConstantCommand{

    public PiCommand(BackendManager bm) {
        super(Math.PI);
        myType = "Pi";
    }
}
