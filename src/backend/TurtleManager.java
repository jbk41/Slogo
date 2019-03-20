package backend;

import Executable.TurtleState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class TurtleManager {

    private List<Double> activeTurtles;
    private Map<Double, TurtleState> stateOfTurtles;

    public TurtleManager(){
        activeTurtles = new ArrayList<>();
        stateOfTurtles = new HashMap<>();
    }

    /**
     * For the set of turtles, add only the active turtles to the list of activeTurtles.
     * Commands are only applied to active turtles.
     * @param turtleIDs - IDs of the active turtles
     */
    public void setActiveTurtles(List<Double> turtleIDs){
        activeTurtles = turtleIDs;
        for (int i = 0; i < activeTurtles.size(); i++){
            double id = activeTurtles.get(i);
            if (!stateOfTurtles.containsKey(id)){
                addTurtle(id);
            }
        }
    }

    /**
     * Returns the list of active turtles
     */
    public List<Double> getActiveTurtles(){
        return activeTurtles;
    }

    /**
     * Returns the number of active turtles
     */
    public int getNumberActiveTurtles(){
        return activeTurtles.size();
    }

    /**
     * Adds the specific turtle with ID to the list of activeTurtles.
     * @param id - of the turtle to add to list.
     */
    private void addTurtle(double id){
        if (!stateOfTurtles.containsKey(id)){
            stateOfTurtles.put(id, new TurtleState(id));
        }
    }

    /**
     * Returns the state of the turtle with id. A State basically holds the previous state of the turtle, as
     * to modify it in the future with more commands.
     * @param id - of turtle to get State.
     * @return
     */
    public TurtleState getStateOfTurtle(double id){
        return stateOfTurtles.get(id);
    }

    /**
     * Sets the new state of the turtle using previous state
     * @param id - id of turtle to modify
     * @param ts - new turtles state
     */
    public void setStateOfTurtle(double id, TurtleState ts){
        stateOfTurtles.put(id, ts);
    }
}
