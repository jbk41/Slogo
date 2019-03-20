package commands;

import backend.BackendManager;

public class SetTowardsCommand extends MovementCommand {

    public SetTowardsCommand(BackendManager bm){
        super(bm);
        setMaxChildren(2);
        setType("SetTowards");
    }

    /**
     * Updates Turtle State: Sets the turtle to face an exact location in the console, where
     * x = input 1
     * y = input 2
     */
    protected void update() {
        getBM().setTowards(getChildren().get(0).getVal(), getChildren().get(1).getVal());
    }
}
