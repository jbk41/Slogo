package commands;

import backend.BackendManager;

public class SetPenColorCommand extends GeneralCommand {
    public SetPenColorCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("SetPenColor");
    }

    /**
     * Executes Command: sets the color of the pen to the value of the input
     */
    public void execute(){
        checkParameterCount();
        getChildren().get(0).execute();
        getBM().setColorIndex(getChildren().get(0).getVal());
    }
}
