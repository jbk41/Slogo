package commands;

import backend.BackendManager;

public class IDCommand extends GeneralCommand {
    public IDCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("ID");
    }
    public void execute(){
        setVal(getBM().getCurrentTurtle().getID());
    }
}
