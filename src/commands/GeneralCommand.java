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

    protected GeneralCommand(){
        myChildren = new ArrayList<>();
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
