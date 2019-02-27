package commands;

import backend.BackendManager;

public class ShowTurtleCommand extends GeneralCommand {

    public ShowTurtleCommand(BackendManager bm) {
        makeReady();
        myMaxChildren = 0;
        myType = "ShowTurtle";
    }

}

