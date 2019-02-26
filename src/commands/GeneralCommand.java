package commands;

import java.util.List;
import java.util.ArrayList;

public abstract class GeneralCommand {

    /**
     * @author Justin Kim
     */
    protected List<GeneralCommand> myChildren;
    protected GeneralCommand myParent;
    protected String myType;
    protected int myMaxChildren;
    protected boolean isReady;
    protected double myVal;

    protected GeneralCommand(){
        myChildren = new ArrayList<>();
        isReady = false;
    }

    public List<GeneralCommand> getChildren(){
        return myChildren;
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

    @Override
    public String toString(){
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
     * Prepares all of the commands in the list (ie forward gets the value of its child)
     */
    public void prepare(){
        return; //do nothing
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

    protected void makeReady(){
        isReady = true;
    }

    protected int getIndexOfCurrentInParent(){
        return (myParent.getChildren().indexOf(this));
    }

    public double getVal() { return myVal; }

    protected double getValFromChild(GeneralCommand command) throws IllegalArgumentException {
        if (!myChildren.contains(command)){
            throw new IllegalArgumentException("Command is not in list of children");
        }
        if (!(command instanceof VariableCommand || command instanceof ConstantCommand)){
            throw new IllegalArgumentException("Only accepts variable and constant types");
        }
        if (!command.isReady()){
            throw new IllegalArgumentException("Arguments not properly prepared");
        }
        if (command instanceof VariableCommand){
            VariableCommand vc = (VariableCommand) command;
            return vc.getVal();
        }
        else { // is constant command
            ConstantCommand cc = (ConstantCommand) command;
            return cc.getVal();
        }
    }
}
