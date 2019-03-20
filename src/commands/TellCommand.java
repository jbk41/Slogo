package commands;
import backend.BackendManager;
import java.util.List;
import java.util.ArrayList;

public class TellCommand extends GeneralCommand {

    public TellCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("Tell");

    }

    /**
     * Adds the Ids of the turtles within the list input to the turtleIDs list. Sets the value to the last turtle in
     * the list
     */
    public void execute(){
        List<Double> turtleIDs = new ArrayList<>();
        GeneralCommand listOfTurtlesCommand = getChildren().get(0);
            for (GeneralCommand child: listOfTurtlesCommand.getChildren()){
                if (!(child instanceof ListEndCommand)){
                    turtleIDs.add(child.getVal());
                }
            }
        getBM().setTurtles(turtleIDs);

        setVal(turtleIDs.get(turtleIDs.size()-1));
    }

}
