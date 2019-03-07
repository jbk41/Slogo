package backend;

import TurtleState.TurtleState;
import commands.UserDefinedCommand;

import java.util.ArrayList;
import java.util.List;

public class BackendManager implements BackendManagerAPI{

    public CommandManager myCM;
    public VariableManager myVM;
    public TurtleManager myTM;
    //public ArrayList<TurtleState> myStates;

    public BackendManager(CommandManager cm, VariableManager vm){
        myCM = cm;
        myVM = vm;

    }

    /*
    Sets values of turtles
     */
    public void forward(double dist) {

        List<Double> activeTurtles = myTM.getActiveTurtles();
        for (int i = 0; i < activeTurtles.size(); i ++){
            double turtleID = activeTurtles.get(i);
            TurtleState currentTurtle = myTM.getStateOfTurtle(turtleID);

            double currX = currentTurtle.getX();
            double currY = currentTurtle.getY();

            double deg = currentTurtle.getDeg();
            double newX = currX + dist * Math.sin(deg * Math.PI / 180);
            double newY = currY + dist * Math.cos(deg * Math.PI / 180);
            boolean clearState = false;

            TurtleState newState = new TurtleState(
                    newX,
                    newY,
                    deg,
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    clearState);
            //TODO: add new State to list of states
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

            double currDeg = currentTurtle.getDeg();
            double newDeg = currentTurtle.getDeg() - deg;

            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    newDeg,
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            //TODO: add new State to list of states
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
            TurtleState newState = new TurtleState(
                    currentTurtle.getX(),
                    currentTurtle.getY(),
                    deg,
                    currentTurtle.getPenState(),
                    currentTurtle.getVisibility(),
                    turtleID,
                    false);
            //TODO: add newState
        }

    }

    public void setTowards(double x, double y) {
        var curr_x = turtle.getX();
        var curr_y = turtle.getY();
        var new_x = curr_x - x;
        var new_y = curr_y - y;
        var deg = Math.tan(new_x/new_y);
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    public void setPosition(double x, double y) {
        TurtleState state = new TurtleState(x, y, turtle.getDeg(), turtle.getPen(), turtle.getVisible, turtle, false);
    }

    public void penUp() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), false, turtle.getVisible, turtle, false);
    }

    public void penDown() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), true, turtle.getVisible, turtle, false);
    }

    public void showTurtle() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), turtle.getPen(), true, turtle, false);
    }

    public void hideTurtle() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), turtle.getPen(), false, turtle, false);
    }

    public void home() {
        TurtleState state = new TurtleState(0, 0, 0, turtle.getPen(), true, turtle, false);
    }

    public void clearScreen() {
        TurtleState state = new TurtleState(0, 0, 0,  false, true, turtle, true);
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

    public void addUserDefinedCommand(UserDefinedCommand userDefinedCommand){
        myCM.addCommand(userDefinedCommand);
    }

    public UserDefinedCommand getUserCommand(String commandName){
        return myCM.getCommand(commandName);
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



}
