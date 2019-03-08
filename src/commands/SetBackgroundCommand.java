package commands;

import backend.BackendManager;

public class SetBackgroundCommand extends GeneralCommand {

    public SetBackgroundCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("SetBackground");
    }

    public void execute(){
        checkParameterCount();
        getChildren().get(0).execute();
        getBM().setBackgroundIndex(getChildren().get(0).getVal());
    }
}
