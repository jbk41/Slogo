package commands;

import backend.BackendManager;

public class ListEndCommand extends GeneralCommand {


    public ListEndCommand(BackendManager bm) {
        super(bm);
        myType = "ListEnd";
    }
}
