package commands;

import backend.BackendManager;

public class IsShowingCommand extends GeneralCommand {

    public IsShowingCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsShowing");
        makeReady();
    }

    public void execute(){
        if (getBM().getCurrentTurtle().getVisibility()){
            setVal(1);
        }
        else {
            setVal(0);
        }

    }
}
