package commands;
import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

import java.util.List;
import java.util.ArrayList;

/**
 * The general command 'node' of the syntax tree. Has a value and a copy of the backend manager and its type. Also
 * has a list of its children and the line number this command was written on.
 * @author Justin
 */
public class GeneralCommand {


    private List<GeneralCommand> myChildren;
    private GeneralCommand myParent;
    private String myType;
    private int myMaxChildren;
    private boolean isReady;
    private double myVal;
    private BackendManager myBM;
    private int myLineNumber;

    /**
     * Creates a new GeneralCommand object and initializes its children list and give it a backend manager.
     * @param bm
     */
    protected GeneralCommand(BackendManager bm){
        myChildren = new ArrayList<>();
        isReady = false;
        myBM = bm;
    }

    /**
     * Copy constructor
     * @param c
     */
    protected GeneralCommand(GeneralCommand c){
        myChildren = c.getChildren();
        myMaxChildren = c.getMaxChildren();
        myParent = c.getParent();
        myType = c.getType();
        myVal = c.getVal();
        myBM = c.getBM();
    }

    /**
     * Gets the command's children.
     * @return
     */
    public List<GeneralCommand> getChildren(){
        return myChildren;
    }

    /**
     * Sets the line number of the command.
     * @param lineNumber
     */
    public void setLineNumber(int lineNumber){
        myLineNumber = lineNumber;
    }

    /**
     * Gets the line number of the command.
     * @return
     */
    public int getLineNumber(){
        return myLineNumber;
    }

    /**
     * Makes the command ready to execute.
     */
    protected void makeReady(){
        isReady = true;
    }

    /**
     * Gets the value of the command.
     * @return
     */
    public double getVal() { return myVal; }

    /**
     * Set the value of the command.
     * @param val
     */
    public void setVal(double val) {myVal = val;}

    /**
     * Returns the max number of children a command can have.
     * @return
     */
    public int getMaxChildren(){
        return myMaxChildren;
    }

    /**
     * Sets the max number of children a command can have.
     * @param children
     */
    public void setMaxChildren(int children) { myMaxChildren = children; }

    /**
     * Gets the type of the command.
     * @return
     */
    public String getType(){
        return myType;
    }

    /**
     * Sets the type of the command.
     * @param type
     */
    public void setType(String type) {myType = type; }

    /**
     * Returrns the command's backend manager.
     * @return
     */
    public BackendManager getBM() {
        return myBM;
    }

    /**
     * Returns the parent of the command.
     * @return
     */
    public GeneralCommand getParent(){
        return myParent;
    }


    /**
     * Sets the parent of the command.
     * @param command
     */
    public void setParent(GeneralCommand command){
        myParent = command;
    }

    /**
     *
     * @return values of each child of Command
     */
    public ArrayList<Double> getChildrenValues() {
        var childValues = new ArrayList<Double>();
        for (GeneralCommand child : this.myChildren){
            childValues.add(getValFromChild(child));
        }
        return childValues;
    }

    /**
     * Prints the parent of the command.
     * @return
     */
    public String printParent(){
        if (myParent != null){
            return this.myParent.toString();
        }
        else {
            return "null";
        }
    }

    /**
     * adds a child to its list of children
     * @param c
     * @return
     */
    public GeneralCommand addChild(GeneralCommand c){
        myChildren.add(c);
        return c;
    }

    /**
     * executes commands (ie forward command will be added to list of executable commands)
     * @throws IllegalArgumentException
     */
    public void execute() throws IllegalArgumentException{
        return; // do nothing
    }

    /**
     * returns true if the node has been prepared properly
     * @return
     */
    public boolean isReady(){
        return this.isReady;
    }

    /**
     * Checks if the number of children the command has equals the max number of children the command can have.
     */
    public void checkParameterCount(){
        if (myChildren.size() != myMaxChildren) {
            myBM.throwError("Incorrect number of parameters", myLineNumber);
        }
    }

    /**
     * Executes the command's children.
     */
    public void executeChildren() {
        for (GeneralCommand child : this.myChildren){
            child.execute();
        }
    }

    /**
     * Gets the value of its child.
     * @param command
     * @return
     * @throws IllegalArgumentException
     */
    public double getValFromChild(GeneralCommand command) throws IllegalArgumentException {
        if (!myChildren.contains(command)){
            throw new IllegalArgumentException("Command is not in list of children");
        }
        return command.getVal();
    }

}
