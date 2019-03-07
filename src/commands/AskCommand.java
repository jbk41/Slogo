package commands;

import backend.BackendManager;

import java.util.ArrayList;
import java.util.List;

public class AskCommand extends GeneralCommand {

    public AskCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 2;
        myType = "Ask";
    }

    public void execute(){
        List<Double> oldActiveTurtles = myBM.getActiveTurtles(); // set active turtles to this list at the end

        List<Double> turtleIDs = new ArrayList<>();
        for (GeneralCommand child: myChildren){
            if (!(child instanceof ListEndCommand)){
                turtleIDs.add(child.getVal());
            }
        }
        myBM.setTurtles(turtleIDs);

        GeneralCommand commands = myChildren.get(1);
        commands.execute();
        myBM.setTurtles(oldActiveTurtles);
    }
}
