package commands;

import backend.BackendManager;

public class HideTurtleCommand extends GeneralCommand {

    public HideTurtleCommand(BackendManager bm) {
        myMaxChildren = 0;
        myType = "HideTurtle";
        makeReady();
    }
}
