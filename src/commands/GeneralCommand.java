package commands;
import java.util.List;
import java.util.ArrayList;

public class GeneralCommand {

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

    public String printParent(){
        if (myParent != null){
            return myParent.getType();
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


    public GeneralCommand addChild(GeneralCommand c){
        myChildren.add(c);
        return c;
    }


    public void execute(){
        
    }
}
