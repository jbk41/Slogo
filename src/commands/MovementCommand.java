package commands;

import backend.BackendManager;

public abstract class MovementCommand extends GeneralCommand {

    final int INDEX = 0;
    public MovementCommand(BackendManager bm){
        super(bm);
    }

    /**
     * Movement command physically move the turtle. Therefore, for execute, the value of the command is the
     * execution of all of its children.
     */
    @Override
    public void execute() {
        checkParameterCount();
        executeChildren();
        setVal(getChildren().get(INDEX).getVal());
        update();
    }

    /**
     * Updates the command and its children accordingly. Each individual command overrides update according
     * to its purpose.
     */
    protected abstract void update();

    /**
     * Returns the type of the command in String format
     */
    @Override
    public String toString() {
        return this.getType();
    }
}
