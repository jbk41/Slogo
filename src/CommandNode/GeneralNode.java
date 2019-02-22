package CommandNode;
import java.util.List;
import java.util.ArrayList;

public abstract class GeneralNode{

    protected List<Node> myChildren;
    protected boolean isComplete;
    protected String myType;
    protected int myMaxChildren;

    protected GeneralNode(){
        myChildren = new ArrayList<>();
    }

    public int getNumChildren(){
        return myChildren.size();
    }

    public int getMaxChildren(){
        return myMaxChildren;
    }

    public String getType(){
        return myType;
    }

    public void addChild(Node n){
        myChildren.add(n);
        if (myChildren.size() == myMaxChildren){
            isComplete = true;
        }
    }

    public abstract void execute();
}
