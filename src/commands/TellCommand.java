package commands;
import backend.BackendManager;
import java.util.List;
import java.util.ArrayList;

public class TellCommand extends GeneralCommand {

    public TellCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 1;
        myType = "Tell";

    }

    public void execute(){
        List<Double> turtleIDs = new ArrayList<>();
        for (GeneralCommand child: myChildren){
            if (!(child instanceof ListEndCommand)){
                turtleIDs.add(child.getVal());
            }
        }

        myBM.setTurtles(turtleIDs);

        myVal = turtleIDs.get(turtleIDs.size()-1);
    }

}
