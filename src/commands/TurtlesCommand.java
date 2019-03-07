package commands;

import backend.BackendManager;

public class TurtlesCommand extends GeneralCommand {

    public TurtlesCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 0;
        myType = "Turtles";
    }

    public void execute(){
        //TODO: send message to console printing out number of active turtles
        myVal = myBM.getNumberActiveTurtles();
    }

}
