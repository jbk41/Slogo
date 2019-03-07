package commands;

import backend.BackendManager;

public class SetTowardsCommand extends MovementCommand {

    public SetTowardsCommand(BackendManager bm){
        super(bm);
        setMaxChildren(2);
        setType("SetTowards");
    }

    protected void update() {
        getBM().setTowards(getChildren().get(0).getVal(), getChildren().get(1).getVal());
    }
}
