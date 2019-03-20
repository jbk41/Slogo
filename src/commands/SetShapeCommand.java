package commands;

import backend.BackendManager;

public class SetShapeCommand extends GeneralCommand {

    public SetShapeCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("SetShapeCommand");
    }

    /**
     * Executes command: Sets the shape of the turtle to the value of the given input
     */
    public void execute(){
        checkParameterCount();
        getChildren().get(0).execute();
        getBM().setShapeIndex(getChildren().get(0).getVal());
    }
}
