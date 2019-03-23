package commands;

import backend.BackendManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Asks a list of turtles to execute a list of commands.
 * @author Justin and Alew
 */
public class AskCommand extends GeneralCommand {

    public AskCommand(BackendManager bm){
        super(bm);
        setMaxChildren(2);
        setType("Ask");
    }

    /**
     * Sets active turtles to all items in the first list. Executes the commands in the second list. Changes list of
     * active turtles to the ones active before the call to Ask.
     */
    public void execute(){
        checkParameterCount();
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
