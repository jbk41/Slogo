package backend;

import Executable.TurtleState;
import Visualization.Turtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Keeps a running list of active turtles and all turtles created. Other basic managerial commands for getting and editing
 * turtle characteristics are in this class.
 * @author Justin
 */
public class TurtleManager {

    private List<Double> activeTurtles;
    private Map<Double, TurtleState> stateOfTurtles;
    //private List<TurtleState> stamps;

    public TurtleManager(){
        activeTurtles = new ArrayList<>();
        stateOfTurtles = new HashMap<>();
        //stamps = new ArrayList<>();
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

    /**
     * makes a turtle stamp
     * @param ts
     */
    public TurtleState addStamp(TurtleState ts){
        TurtleState stamp = new TurtleState(ts);
        stateOfTurtles.put(stamp.getID(), stamp);
        return stamp;
    }

    public List<TurtleState> getStamps(){
        List<TurtleState> tsList = new ArrayList<>();
        for (double d: stateOfTurtles.keySet()){
            if (d < 0){
                tsList.add(stateOfTurtles.get(d));
                System.out.println(d);
            }
        }
        return tsList;
    }
}
