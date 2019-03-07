package commands;

import backend.BackendManager;

public class IsPenDownCommand extends GeneralCommand {

    public IsPenDownCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsPenDown");
        makeReady();
    }

}
