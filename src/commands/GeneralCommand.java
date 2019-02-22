package commands;
import java.util.List;
import java.util.LinkedList;

public abstract class GeneralCommand {

    /**
     * @author Justin Kim
     */
    protected List<GeneralCommand> myChildren;
    protected String myType;
    protected int myMaxChildren;

    protected GeneralCommand(){
        myChildren = new LinkedList<>();
    }

    public int getNumChildren(){
        return myChildren.size();
    }

    public boolean isEmpty(){
        return (myChildren.size() == 0);
    }

    public List<GeneralCommand> getChildren(){
        return myChildren;
    }

    public int getMaxChildren(){
        return myMaxChildren;
    }

    public String getType(){
        return myType;
    }

    public boolean isFull(){
        return (myChildren.size() == myMaxChildren);
    }

    public GeneralCommand addChild(GeneralCommand c){
        myChildren.add(c);
        return c;
    }


    public abstract void execute();
}
