package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class RightCommand extends MovementCommand {

    final int VAL_INDEX = 0;
    public RightCommand (BackendManager bm){
        super(bm);
        setType("Right");
        setMaxChildren(1);
    }

    /**
     * Updates the Turtle State - rotates the turtle to the right by input one in degrees
     */
    @Override
    protected void update() {
        getBM().right(getChildren().get(VAL_INDEX).getVal());
    }
}
