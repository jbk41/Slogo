package backend;
import commands.GeneralCommand;
import commands.UserDefinedCommand;
import Executable.*;

import java.util.List;
import java.util.Map;

/**
 * The backend manager keeps track of the backend characteristics such as managing variables, user defined commands, and
 * turtles. It also communicates with the Backend model to limit some communication between the frontend and backend
 * @author: Justin
 */
public interface BackendManagerAPI {

    /**
     * Looks at the current positions of active turtles and moves them dist forward.
     * @param dist
     */
    public void forward(double dist);

    /**
     * Looks at the current positions of active turtles and moves them dist backward.
     * @param dist
     */
    public void backward(double dist);

    /**
     * Looks at the current positions of active turtles and moves them dist left.
     * @param dist
     */
    public void left (double dist);

    /**
     * Looks at the current positions of active turtles and moves them dist right.
     * @param dist
     */
    public void right(double dist);

    /**
     * Sets active turtles to face towards deg.
     * @param deg
     */
    public void setHeading(double deg);

    /**
     * Sets active turtles to face towards (x, y).
     * @param x
     * @param y
     */
    public void setTowards(double x, double y);

    /**
     * Moves active turtles to set toward (x, y).
     * @param x
     * @param y
     */
    public void setPosition(double x, double y);

    /**
     * Sets active turtles to have their pens up.
     */
    public void penUp();

    /**
     * Sets active turtles to have their pens down.
     */
    public void penDown();

    /**
     * Makes all active turtles visible.
     */
    public void showTurtle();

    /**
     * Makes all active turtles invisible.
     */
    public void hideTurtle();

    /**
     * Makes all active turtles go home (to (0, 0)).
     */
    public void home();

    /**
     * Resets all turtles
     */
    public void clearScreen();

    /**
     * Adds an error executable to the list of executables for the front end to see.
     * @param error error to be printed
     * @param lineNumber line on which the error occurs
     */
    public void throwError(String error, int lineNumber);

    /**
     * Sets value of varName to val.
     * @param varName
     * @param val
     */
    public void setVariable(String varName, double val);

    /**
     * Returns true if varName has been declared.
     * @param varName
     * @return
     */
    public boolean hasVariable(String varName);

    /**
     * Returns value held by varName.
     * @param varName
     * @return
     */
    public double getVariable(String varName);

    /**
     * Returns true if commandName is defined.
     * @param commandName
     * @return
     */
    public boolean containsCommand(String commandName);

    /**
     * Adds the userDefinedCommand syntax tree to the list of user defined commands.
     * @param commandName
     * @param userDefinedCommand
     */
    public void addUserDefinedCommand(String commandName, UserDefinedCommand userDefinedCommand);

    /**
     * Returns the commandName syntax tree.
     * @param commandName
     * @return
     */
    public UserDefinedCommand getUserCommand(String commandName);

    /**
     * Sets the max number of variables for the command commandName to take in
     * @param commandName
     * @param args
     */
    public void setMaxVarForUserDefinedCommand(String commandName, int args);

    /**
     * Sets active turtles to turtleIDs.
     * @param turtleIDs
     */
    public void setTurtles(List<Double> turtleIDs);

    /**
     * Returns number of active turtles.
     * @return
     */
    public int getNumberActiveTurtles();

    /**
     * Returns list of active turtles (IDs).
     * @return
     */
    public List<Double> getActiveTurtles();

    /**
     * Returns the turtle that a command was most recently executed on. Different from the list of active turtles
     * as only one turtle can be moved at a time.
     * @return
     */
    public TurtleState getCurrentTurtle();

    /**
     * Clears all of the current commands to be executed by front end.
     */
    public void clearCommands();

    /**
     * Returns the variableMap.
     * @return
     */
    public Map<String, Double> getVarMap();

    /**
     * Returns the list of all commands.
     * @return
     */
    public List<Executable> getCommands();

    /**
     * Sets background color.
     * @param backgroundIndex
     */
    public void setBackgroundIndex(double backgroundIndex);

    /**
     * Sets color of the pen.
     * @param colorIndex
     */
    public void setColorIndex(double colorIndex);

    /**
     * Sets size of the pen.
     * @param penSize
     */
    public void setPenSize(double penSize);

    /**
     * Sets shape of the turtles.
     * @param shapeIndex
     */
    public void setShapeIndex(double shapeIndex);

    /**
     * Returns current state of the environment.
     * @return
     */
    public EnvironmentState getCurrentEnvironment();

    /**
     * Adds a new color to the color palette.
     * @param index
     * @param r
     * @param g
     * @param b
     */
    public void setColorPaletteEntry(double index, double r, double g, double b);

}
