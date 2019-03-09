package commands;

import backend.BackendManager;

public class SetBackgroundCommand extends GeneralCommand {

    final int VAL_INDEX = 0;

    public SetBackgroundCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("SetBackground");
    }

    public void execute(){
        checkParameterCount();
        getChildren().get(VAL_INDEX).execute();
        getBM().setBackgroundIndex(getChildren().get(VAL_INDEX).getVal());
    }
}
