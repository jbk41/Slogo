package backend;

import Executable.*;
import commands.UserDefinedCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;

public class BackendManager implements BackendManagerAPI{

    private CommandManager myCM;
    private VariableManager myVM;
    private TurtleManager myTM;
    private TurtleState myCurrentTurtle;
    private EnvironmentState myCurrentEnvironment;
    private List<Executable> myCommands;

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
    public void forward(double dist) {
        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);
            myCurrentTurtle = currentTurtle;
            TurtleState newState = new TurtleState(
                    currentTurtle.getX() + dist * Math.sin(currentTurtle.getDeg() * Math.PI / 180),
                    currentTurtle.getY() + dist * Math.cos(currentTurtle.getDeg() * Math.PI / 180),
                    currentTurtle.getDeg(),
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            myTM.setStateOfTurtle(turtleID, newState);
            myCommands.add(newState);
        }
    }

    public void backward(double dist) {
        forward(dist * -1);
    }

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

    public void right(double deg) {
        left(deg * -1);
    }

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
    public void throwError(String error, int lineNumber){
        ErrorMessage e = new ErrorMessage(error, lineNumber);
        myCommands.add(e);
    }


    /*
    meant for backend control (variables)
     */
    public void setVariable(String varName, double val){
        myVM.set(varName, val);
    }

    public boolean hasVariable(String varName){
        return myVM.contains(varName);
    }

    public double getVariable(String varName){
        return myVM.getVal(varName);
    }


    /*
    Meant for backend control (user defined commands)
     */
    public boolean containsCommand(String commandName) {
        return myCM.containsCommand(commandName);
    }

    public void addUserDefinedCommand(String commandName, UserDefinedCommand userDefinedCommand){
        myCM.addCommand(commandName, userDefinedCommand);
    }

    public UserDefinedCommand getUserCommand(String commandName){
        return myCM.getCommand(commandName);
    }

    public void setMaxVarForUserDefinedCommand(String commandName, int args){
        myCM.setMaxArgs(commandName, args);
    }



    /*
    Meant for backend control (turtles)
     */
    public void setTurtles(List<Double> turtleIDs){
        myTM.setActiveTurtles(turtleIDs);
    }

    public int getNumberActiveTurtles(){
        return myTM.getNumberActiveTurtles();
    }

    public List<Double> getActiveTurtles(){
        return myTM.getActiveTurtles();
    }

    public TurtleState getCurrentTurtle(){
        return myCurrentTurtle;
    }

    /*
    For frontend (communication with BackendModel)
     */

    public void clearCommands(){
        myCommands.clear();
    }

    public Map<String, Double> getVarMap(){
        return Collections.unmodifiableMap(myVM.getVariableMap());
    }

    public List<Executable> getCommands(){

        return myCommands;
    }


    /*
    Environment states
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

    public void setColorIndex(double colorIndex){
        EnvironmentState es = new EnvironmentState(
                myCurrentEnvironment.getBackgroundIndex(),
                colorIndex,
                myCurrentEnvironment.getPenSize(),
                myCurrentEnvironment.getShapeIndex()
        );
        myCommands.add(es);
    }

    public void setPenSize(double penSize){
        EnvironmentState es = new EnvironmentState(
                myCurrentEnvironment.getBackgroundIndex(),
                myCurrentEnvironment.getColorIndex(),
                penSize,
                myCurrentEnvironment.getShapeIndex()
        );
        myCommands.add(es);
    }

    public void setShapeIndex(double shapeIndex){
        EnvironmentState es = new EnvironmentState(
                myCurrentEnvironment.getBackgroundIndex(),
                myCurrentEnvironment.getColorIndex(),
                myCurrentEnvironment.getPenSize(),
                shapeIndex
        );
        myCommands.add(es);
    }

    public EnvironmentState getCurrentEnvironment(){
        return myCurrentEnvironment;
    }

    public void setColorPaletteEntry(double index, double r, double g, double b){
        myCommands.add(new ColorPaletteEntry(index, r, g, b));
    }
}
