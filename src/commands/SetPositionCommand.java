package commands;

import backend.BackendManager;

public class SetPositionCommand extends MovementCommand {

    public SetPositionCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(2);
        setType("SetTowards");
    }

    @Override
    protected void update() {
        getBM().setPosition(getChildren().get(0).getVal(), getChildren().get(1).getVal());
    }
}
