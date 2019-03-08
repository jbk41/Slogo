package commands;

import backend.BackendManager;

public class SetPenSizeCommand extends GeneralCommand {
    public SetPenSizeCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("SetPenSizeCommand");
    }

    public void execute(){
        checkParameterCount();
        getChildren().get(0).execute();
        getBM().setPenSize(getChildren().get(0).getVal());
    }
}
