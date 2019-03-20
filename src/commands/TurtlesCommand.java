package commands;

import backend.BackendManager;

public class TurtlesCommand extends GeneralCommand {

    public TurtlesCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("Turtles");
    }

    /**
     * Executes the command. Sets the val to the number of active turtles.
     */
    public void execute(){
        setVal(getBM().getNumberActiveTurtles());
    }

}
