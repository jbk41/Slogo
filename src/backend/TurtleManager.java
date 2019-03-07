package backend;

import TurtleState.TurtleState;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class TurtleManager {

    private List<Double> activeTurtles;
    private Map<Double, TurtleState> stateOfTurtles;

    public TurtleManager(){
        stateOfTurtles = new HashMap<>();
    }

    public void setActiveTurtles(List<Double> turtleIDs){
        activeTurtles = turtleIDs;
        for (int i = 0; i < activeTurtles.size(); i++){
            double id = activeTurtles.get(i);
            if (!stateOfTurtles.containsKey(id)){
                addTurtle(id);
            }
        }
    }

    public List<Double> getActiveTurtles(){
        return activeTurtles;
    }

    public int getNumberActiveTurtles(){
        return activeTurtles.size();
    }

    private void addTurtle(double id){
        if (!stateOfTurtles.containsKey(id)){
            stateOfTurtles.put(id, new TurtleState(id));
        }
    }

    public TurtleState getStateOfTurtle(double id){
        return stateOfTurtles.get(id);
    }
}
