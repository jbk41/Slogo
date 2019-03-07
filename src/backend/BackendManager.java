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
    public void forward(double val) {
        var x = turtle.getX();
        var y = turtle.getY();
        var deg = turtle.getDeg();
        x += val * Math.sin(deg * Math.PI / 180);
        y += val * Math.cos(deg * Math.PI / 180);
        TurtleState state = new TurtleState(x, y, deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    public void backward(double val) {
        var x = turtle.getX();
        var y = turtle.getY();
        var deg = turtle.getDeg();
        x -= val * Math.sin(deg * Math.PI / 180);
        y -= val * Math.cos(deg * Math.PI / 180);
        TurtleState state = new TurtleState(x, y, deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    public void left(double val) {
        var deg = turtle.getDeg();
        deg -= val;
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    public void right(double deg) {
        var deg = turtle.getDeg();
        deg += val;
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    public void setHeading(double deg) {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
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

}
