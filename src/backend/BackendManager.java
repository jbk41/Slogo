package backend;

import TurtleState.TurtleManager;
import TurtleState.TurtleState;
import commands.BackwardCommand;

import java.util.ArrayList;

public class BackendManager implements BackendManagerAPI{

    public CommandManager myCM;
    public VariableManager myVM;
    public ArrayList<TurtleState> myStates;

    public BackendManager(CommandManager cm, VariableManager vm){
        myCM = cm;
        myVM = vm;
        myStates = new ArrayList<TurtleState>();
    }

    @Override
    public void forward(double val) {
        var x = turtle.getX();
        var y = turtle.getY();
        var deg = turtle.getDeg();
        x += val * Math.sin(deg * Math.PI / 180);
        y += val * Math.cos(deg * Math.PI / 180);
        TurtleState state = new TurtleState(x, y, deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    @Override
    public void backward(double val) {
        var x = turtle.getX();
        var y = turtle.getY();
        var deg = turtle.getDeg();
        x -= val * Math.sin(deg * Math.PI / 180);
        y -= val * Math.cos(deg * Math.PI / 180);
        TurtleState state = new TurtleState(x, y, deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    @Override
    public void left(double val) {
        var deg = turtle.getDeg();
        deg -= val;
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    @Override
    public void right(double deg) {
        var deg = turtle.getDeg();
        deg += val;
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    @Override
    public void setHeading(double deg) {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    @Override
    public void setTowards(double x, double y) {
        var curr_x = turtle.getX();
        var curr_y = turtle.getY();
        var new_x = curr_x - x;
        var new_y = curr_y - y;
        var deg = Math.tan(new_x/new_y);
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), deg, turtle.getPen(), turtle.getVisible, turtle, false);
    }

    @Override
    public void setPosition(double x, double y) {
        TurtleState state = new TurtleState(x, y, turtle.getDeg(), turtle.getPen(), turtle.getVisible, turtle, false);
    }

    @Override
    public void penUp() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), false, turtle.getVisible, turtle, false);
    }

    @Override
    public void penDown() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), true, turtle.getVisible, turtle, false);
    }

    @Override
    public void showTurtle() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), turtle.getPen(), true, turtle, false);
    }

    @Override
    public void hideTurtle() {
        TurtleState state = new TurtleState(turtle.getX(), turtle.getY(), turtle.getDeg(), turtle.getPen(), false, turtle, false);
    }

    @Override
    public void home() {
        TurtleState state = new TurtleState(0, 0, 0, turtle.getPen(), true, turtle, false);
    }

    @Override
    public void clearScreen() {
        TurtleState state = new TurtleState(0, 0, 0,  false, true, turtle, true);
    }

    @Override
    public boolean containsCommand(String key) {
        return false;
    }

    public CommandManager getCommandManager() { return myCM; }

    public VariableManager getVariableManager() { return myVM; }

    public void setVariable(String varName, double val){
        myVM.set(varName, val);
    }

    public boolean hasVariable(String varName){
        return myVM.contains(varName);
    }

    public double getValOfVar(String varName){
        return myVM.getVal(varName);
    }

}
