package commands;

import backend.BackendManager;

public abstract class StatementCommand extends GeneralCommand {


    public StatementCommand(BackendManager bm){
        super(bm);
    }


    /**
     * Statement commands are special, they update the TurtleState directly. Update functions are overridden respectively.
     */
    public abstract void update();

    /**
     * Execute command: Updates the Turtle
     */
    @Override
    public void execute() {
        update();
    }

    /**
     * Returns the type of the command, in string format
     * @return
     */
    @Override
    public String toString(){
        return getType();
    }
}

