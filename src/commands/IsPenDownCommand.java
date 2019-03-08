package commands;

import backend.BackendManager;

public class IsPenDownCommand extends GeneralCommand {

    public IsPenDownCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("IsPenDown");
        makeReady();
    }

    public void execute(){
        if (getBM().getCurrentTurtle().getPenState()){
            setVal(1);
        }
        else {
            setVal(0);
        }
    }

}
