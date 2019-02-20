package CommandNode;

public class Node implements NodeInterface {

    public String myName;
    protected boolean hasLeft;
    protected boolean hasRight;
    protected NodeInterface left;
    protected NodeInterface right;
    protected int myNumChildren;
    protected int myMaxChildren;

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

    public String getName(){
        return myName;
    }

    public NodeInterface getLeft(){
        return left;
    }
    public NodeInterface getRight(){
        return right;
    }
    public void setLeft(NodeInterface n){
        left = n;
    }
    public void setRight(NodeInterface n){
        right = n;
    }
    public void addChild(){
        myNumChildren ++;
    }

}
