package commands;

import backend.BackendManager;

import java.util.ArrayList;
import java.util.List;

public class AskCommand extends GeneralCommand {

    public AskCommand(BackendManager bm){
        super(bm);
        setMaxChildren(2);
        setType("Ask");
    }

    public void execute(){
        List<Double> oldActiveTurtles = getBM().getActiveTurtles(); // set active turtles to this list at the end

        List<Double> turtleIDs = new ArrayList<>();
        for (GeneralCommand child: getChildren()){
            if (!(child instanceof ListEndCommand)){
                turtleIDs.add(child.getVal());
            }
        }
        getBM().setTurtles(turtleIDs);

        GeneralCommand commands = getChildren().get(1);
        commands.execute();
        getBM().setTurtles(oldActiveTurtles);
    }
}
