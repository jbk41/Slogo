package commands;

import backend.BackendManager;

public class TurtlesCommand extends GeneralCommand {

    public TurtlesCommand(BackendManager bm){
        super(bm);
        setMaxChildren(0);
        setType("Turtles");
    }

    public void execute(){
        //TODO: send message to console printing out number of active turtles
        setVal(getBM().getNumberActiveTurtles());
    }

}
