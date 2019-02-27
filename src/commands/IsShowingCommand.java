package commands;

import backend.BackendManager;

public class IsShowingCommand extends GeneralCommand {

    public IsShowingCommand(BackendManager bm){
        myMaxChildren = 0;
        myType = "IsPenDown";
        makeReady();
    }
}
