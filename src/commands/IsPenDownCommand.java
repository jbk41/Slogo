package commands;

import backend.BackendManager;

public class IsPenDownCommand extends GeneralCommand {

    final int TRUE = 1;
    final int FALSE = 0;

    public IsPenDownCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsPenDown");
        makeReady();
    }

    public void execute(){
        if (getBM().getCurrentTurtle().getPenState()){
            setVal(TRUE);
        }
        else {
            setVal(FALSE);
        }
    }

}
