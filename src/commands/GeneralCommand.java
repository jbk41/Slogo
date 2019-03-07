package commands;
import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

import java.util.List;
import java.util.ArrayList;

public class GeneralCommand {

    /**
     * @author Justin Kim
     */
    private List<GeneralCommand> myChildren;
    private GeneralCommand myParent;
    private String myType;
    private int myMaxChildren;
    private boolean isReady;
    private double myVal;
    private BackendManager myBM;

    protected GeneralCommand(BackendManager bm){
        myChildren = new ArrayList<>();
        isReady = false;
        myBM = bm;
    }

    protected GeneralCommand(GeneralCommand c){
        myChildren = c.getChildren();
        myMaxChildren = c.getMaxChildren();
        myParent = c.getParent();
        myType = c.getType();
        myVal = c.getVal();
        myBM = c.getBM();
    }

    public List<GeneralCommand> getChildren(){
        return myChildren;
    }

    //public String getVarName() {return ""; }

    public BackendManager getBM() {
        return myBM;
    }
    public GeneralCommand getParent(){
        return myParent;
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

    public int getMaxChildren(){
        return myMaxChildren;
    }

    public String printParent(){
        if (myParent != null){
            return this.myParent.toString();
        }
        else {
            return "null";
        }
    }


    public void setParent(GeneralCommand command){
        myParent = command;
    }

    public String getType(){
        return myType;
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

    protected void checkParameterCount() throws IllegalAccessError{
        if (myChildren.size() != myMaxChildren) {
            throw new IllegalArgumentException(myType + " takes in " + myMaxChildren + " parameters");
        }
    }

    public void executeChildren() {
        for (GeneralCommand child : this.myChildren){
            child.execute();
        }
    }


    protected void makeReady(){
        isReady = true;
    }

    //protected int getIndexOfCurrentInParent(){
    //    return (myParent.getChildren().indexOf(this));
    //}

    public double getVal() { return myVal; }

    protected double getValFromChild(GeneralCommand command) throws IllegalArgumentException {
        if (!myChildren.contains(command)){
            throw new IllegalArgumentException("Command is not in list of children");
        }
        return command.getVal();
    }

}
