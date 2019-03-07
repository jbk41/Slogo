package commands;

import backend.BackendManager;

public class IsShowingCommand extends GeneralCommand {

    public IsShowingCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsPenDown");
        makeReady();
    }
}
