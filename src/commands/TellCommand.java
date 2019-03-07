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

    public void execute(){
        List<Double> turtleIDs = new ArrayList<>();
        for (GeneralCommand child: getChildren()){
            if (!(child instanceof ListEndCommand)){
                turtleIDs.add(child.getVal());
            }
        }

        getBM().setTurtles(turtleIDs);

        setVal(turtleIDs.get(turtleIDs.size()-1));
    }

}
