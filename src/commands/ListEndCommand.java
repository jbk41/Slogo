package commands;

import backend.BackendManager;

/**
 * Command that represents the end of a list.
 * @author Justin
 */
public class ListEndCommand extends GeneralCommand {

    public ListEndCommand(BackendManager bm) {
        super(bm);
        setType("ListEnd");
    }
}
