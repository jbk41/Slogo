package commands;

import backend.BackendManager;

public class IsShowingCommand extends GeneralCommand {

    final int TRUE = 1;
    final int FALSE = 0;

    public IsShowingCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsShowing");
        makeReady();
    }

    public void execute(){
        if (getBM().getCurrentTurtle().getVisibility()){
            setVal(TRUE);
        }
        else {
            setVal(FALSE);
        }

    }
}
