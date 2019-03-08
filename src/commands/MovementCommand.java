package commands;

import backend.BackendManager;

public abstract class MovementCommand extends GeneralCommand {

    public MovementCommand(BackendManager bm){
        super(bm);
    }

    @Override
    public void execute() {
        checkParameterCount();
        executeChildren();
        setVal(getChildren().get(0).getVal());
        update();
    }

    protected abstract void update();

    @Override
    public String toString() {
        return this.getType();
    }
}
