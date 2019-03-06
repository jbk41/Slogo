package commands;

import backend.BackendManager;

public class IsShowingCommand extends GeneralCommand {

    public IsShowingCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 0;
        myType = "IsPenDown";
        makeReady();
    }

    public IsShowingCommand(GeneralCommand c){
        super(c);
    }
}
