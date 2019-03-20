package backend;

import Executable.*;
import commands.UserDefinedCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;

public class BackendManager implements BackendManagerAPI{

    final int REVERSE_INT = -1;
    final int PI_RAD = 180;

    private CommandManager myCM;
    private VariableManager myVM;
    private TurtleManager myTM;
    private TurtleState myCurrentTurtle;
    private EnvironmentState myCurrentEnvironment;
    private List<Executable> myCommands;

    /**
     * Creates a new backend manager. Controls everything internal to the backend such as keeping track of
     * variables, user commands, turtles, commands to give to the front end, and current states of the front end
     */
    public BackendManager(){
        myCM = new CommandManager();
        myVM = new VariableManager();
        myTM = new TurtleManager();
        myCommands = new ArrayList<Executable>();
        myCurrentEnvironment = new EnvironmentState();
    }

    /*
    Create Turtle State from Command
     */

    /**
     * Looks at the current positions of active turtles and moves them dist forward.
     * @param dist
     */
    public void forward(double dist) {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX() + dist * Math.sin(currentTurtle.getDeg() * Math.PI / PI_RAD),
                    currentTurtle.getY() + dist * Math.cos(currentTurtle.getDeg() * Math.PI / PI_RAD),
                    currentTurtle.getDeg(),
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }


    /**
     * Looks at the current positions of active turtles and moves them dist backward.
     * @param dist
     */
    public void backward(double dist) {
        forward(dist * REVERSE_INT);
    }

    /**
     * Looks at the current positions of active turtles and moves them dist left.
     * @param deg
     */
    public void left(double deg) {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    currentTurtle.getDeg() - deg,
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Looks at the current positions of active turtles and moves them dist right.
     * @param deg
     */
    public void right(double deg) {
        left(deg * REVERSE_INT);
    }

    /**
     * Sets active turtles to face towards deg.
     * @param deg
     */
    public void setHeading(double deg) {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++) {
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    deg,
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Sets active turtles to face towards (x, y).
     * @param x
     * @param y
     */
    public void setTowards(double x, double y) {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i++) {
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;

            var new_x = currentTurtle.getX() - x;
            var new_y = currentTurtle.getY() - y;

            TurtleState newState = new TurtleState(
                    new_x,
                    new_y,
                    Math.tan(new_x/new_y),
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Moves active turtles to set toward (x, y).
     * @param x
     * @param y
     */
    public void setPosition(double x, double y) {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    x,
                    y,
                    currentTurtle.getDeg(),
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Sets active turtles to have their pens up.
     */
    public void penUp() {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    currentTurtle.getDeg(),
                    false,
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Sets active turtles to have their pens down.
     */
    public void penDown() {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    currentTurtle.getDeg(),
                    true,
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Makes all active turtles visible.
     */
    public void showTurtle() {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    currentTurtle.getDeg(),
                    currentTurtle.getPenState(),
                    true,
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Makes all active turtles invisible.
     */
    public void hideTurtle() {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    currentTurtle.getDeg(),
                    currentTurtle.getPenState(),
                    false,
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Makes all active turtles go home (to (0, 0)).
     */
    public void home() {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    0,
                    0,
                    0,
                    currentTurtle.getPenState(),
                    true,
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /**
     * Resets all turtles
     */
    public void clearScreen() {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    0,
                    0,
                    0,
                    false,
                    true,
                    turtleID,
                    true);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    /*
    Handling errors
    */

    /**
     * Adds an error executable to the list of executables for the front end to see.
     * @param error error to be printed
     * @param lineNumber line on which the error occurs
     */
    public void throwError(String error, int lineNumber){
        ErrorMessage e = new ErrorMessage(error, lineNumber);
        myCommands.add(e);
    }


    /*
    meant for backend control (variables)
     */

    /**
     * Sets value of varName to val.
     * @param varName
     * @param val
     */
    public void setVariable(String varName, double val){
        myVM.set(varName, val);
    }

    /**
     * Returns true if varName has been declared.
     * @param varName
     * @return
     */
    public boolean hasVariable(String varName){
        return myVM.contains(varName);
    }

    /**
     * Returns value held by varName.
     * @param varName
     * @return
     */
    public double getVariable(String varName){
        return myVM.getVal(varName);
    }


    /*
    Meant for backend control (user defined commands)
     */

    /**
     * Returns true if commandName is defined.
     * @param commandName
     * @return
     */
    public boolean containsCommand(String commandName) {
        return myCM.containsCommand(commandName);
    }

    /**
     * Adds the userDefinedCommand syntax tree to the list of user defined commands.
     * @param commandName
     * @param userDefinedCommand
     */
    public void addUserDefinedCommand(String commandName, UserDefinedCommand userDefinedCommand){
        myCM.addCommand(commandName, userDefinedCommand);
    }

    /**
     * Returns the commandName syntax tree.
     * @param commandName
     * @return
     */
    public UserDefinedCommand getUserCommand(String commandName){
        return myCM.getCommand(commandName);
    }

    /**
     * Sets the max number of variables for the command commandName to take in
     * @param commandName
     * @param args
     */
    public void setMaxVarForUserDefinedCommand(String commandName, int args){
        myCM.setMaxArgs(commandName, args);
    }



    /*
    Meant for backend control (turtles)
     */

    /**
     * Sets active turtles to turtleIDs.
     * @param turtleIDs
     */
    public void setTurtles(List<Double> turtleIDs){
        myTM.setActiveTurtles(turtleIDs);
    }

    /**
     * Returns number of active turtles.
     * @return
     */
    public int getNumberActiveTurtles(){
        return myTM.getNumberActiveTurtles();
    }

    /**
     * Returns list of active turtles (IDs).
     * @return
     */
    public List<Double> getActiveTurtles(){
        return myTM.getActiveTurtles();
    }

    /**
     * Returns the turtle that a command was most recently executed on. Different from the list of active turtles
     * as only one turtle can be moved at a time.
     * @return
     */
    public TurtleState getCurrentTurtle(){
        return myCurrentTurtle;
    }

    /*
    For frontend (communication with BackendModel)
     */
    /**
     * Clears all of the current commands to be executed by front end.
     */
    public void clearCommands(){
        myCommands.clear();
    }

    /**
     * Returns the variableMap.
     * @return
     */
    public Map<String, Double> getVarMap(){
        return Collections.unmodifiableMap(myVM.getVariableMap());
    }

    /**
     * Returns the list of all commands.
     * @return
     */
    public List<Executable> getCommands(){

        return myCommands;
    }


    /*
    Environment states
     */

    /**
     * Sets background color.
     * @param backgroundIndex
     */
    public void setBackgroundIndex(double backgroundIndex){
        EnvironmentState es = new EnvironmentState(
                backgroundIndex,
                myCurrentEnvironment.getColorIndex(),
                myCurrentEnvironment.getPenSize(),
                myCurrentEnvironment.getShapeIndex()
        );
        myCommands.add(es);
    }

    /**
     * Sets color of the pen.
     * @param colorIndex
     */
    public void setColorIndex(double colorIndex){
        EnvironmentState es = new EnvironmentState(
                myCurrentEnvironment.getBackgroundIndex(),
                colorIndex,
                myCurrentEnvironment.getPenSize(),
                myCurrentEnvironment.getShapeIndex()
        );
        myCommands.add(es);
    }

    /**
     * Sets size of the pen.
     * @param penSize
     */
    public void setPenSize(double penSize){
        EnvironmentState es = new EnvironmentState(
                myCurrentEnvironment.getBackgroundIndex(),
                myCurrentEnvironment.getColorIndex(),
                penSize,
                myCurrentEnvironment.getShapeIndex()
        );
        myCommands.add(es);
    }

    /**
     * Sets shape of the turtles.
     * @param shapeIndex
     */
    public void setShapeIndex(double shapeIndex){
        EnvironmentState es = new EnvironmentState(
                myCurrentEnvironment.getBackgroundIndex(),
                myCurrentEnvironment.getColorIndex(),
                myCurrentEnvironment.getPenSize(),
                shapeIndex
        );
        myCommands.add(es);
    }

    /**
     * Returns current state of the environment.
     * @return
     */
    public EnvironmentState getCurrentEnvironment(){
        return myCurrentEnvironment;
    }

    /**
     * Adds a new color to the color palette.
     * @param index
     * @param r
     * @param g
     * @param b
     */
    public void setColorPaletteEntry(double index, double r, double g, double b){
        myCommands.add(new ColorPaletteEntry(index, r, g, b));
    }
}
