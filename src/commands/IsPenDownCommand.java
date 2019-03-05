package commands;

import backend.BackendManager;

public class IsPenDownCommand extends GeneralCommand {

    public IsPenDownCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 0;
        myType = "IsPenDown";
        makeReady();
    }
}
