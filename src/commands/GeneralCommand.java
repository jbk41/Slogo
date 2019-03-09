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
    private int myLineNumber;

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

    public void setLineNumber(int lineNumber){
        myLineNumber = lineNumber;
    }

    public int getLineNumber(){
        return myLineNumber;
    }
    //public String getVarName() {return ""; }
    protected void makeReady(){
        isReady = true;
    }

    public double getVal() { return myVal; }

    public void setVal(double val) {myVal = val;}

    public int getMaxChildren(){
        return myMaxChildren;
    }

    public void setMaxChildren(int children) { myMaxChildren = children; }

    public String getType(){
        return myType;
    }

    public void setType(String type) {myType = type; }

    public BackendManager getBM() {
        return myBM;
    }


    public GeneralCommand getParent(){
        return myParent;
    }
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

    public void checkParameterCount(){
        if (myChildren.size() != myMaxChildren) {
            myBM.throwError("Incorrect number of parameters", myLineNumber);
        }
    }

    public void executeChildren() {
        for (GeneralCommand child : this.myChildren){
            child.execute();
        }
    }

    public double getValFromChild(GeneralCommand command) throws IllegalArgumentException {
        if (!myChildren.contains(command)){
            throw new IllegalArgumentException("Command is not in list of children");
        }
        return command.getVal();
    }





}
