package commands;

import backend.BackendManager;

public class SetPositionCommand extends MovementCommand {

    public SetPositionCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(2);
        setType("SetTowards");
    }

    /**
     * Updates TurtleState: Sets position of the turtle to:
     * x = input 1
     * y = input 2
     */
    @Override
    protected void update() {
        getBM().setPosition(getChildren().get(0).getVal(), getChildren().get(1).getVal());
    }
}
