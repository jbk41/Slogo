package CommandNode;

public class ForwardNode extends GeneralNode {


    public ForwardNode(){
        super();
        isComplete = false;
        myType = "forward";
        myMaxChildren = 1;
    }

    @Override
    public void execute(){

    }


}
