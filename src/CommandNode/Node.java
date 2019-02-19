package CommandNode;

public class Node implements NodeInterface {

    public String myName;
    protected boolean hasLeft;
    protected boolean hasRight;
    protected Node left;
    protected Node right;
    protected int myNumChildren;

    protected Node(String s){
        myName = s;
        myNumChildren = 0;
    }


    public int getMaxChildren(){
        return myNumChildren;
    }

    public int getNumChildren(){
        return myNumChildren;
    }

    public void addChild(){
        myNumChildren ++;
    }

    public String getName(){
        return myName;
    }
}
