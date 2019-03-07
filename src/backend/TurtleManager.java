package backend;

import TurtleState.TurtleState;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class TurtleManager {

    private List<Integer> activeTurtles;
    private Map<Integer, TurtleState> stateOfTurtles;

    public TurtleManager(){
        stateOfTurtles = new HashMap<>();
    }

    public void setActiveTurtles(List<Integer> turtleIDs){
        activeTurtles = turtleIDs;
    }

    public List<Integer> getActiveTurtles(){
        return activeTurtles;
    }

    public void addTurtle(int id){
        if (!stateOfTurtles.containsKey(id)){
            stateOfTurtles.put(id)
        }
    }

    public TurtleState getStateOfTurtle(int id){
        return stateOfTurtles.get(id);
    }
}
