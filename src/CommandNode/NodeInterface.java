package CommandNode;
import java.util.List;

public interface NodeInterface {

    public int getNumChildren();
    public int getMaxChildren();
    public String getName();
    public NodeInterface getLeft();
    public NodeInterface getRight();
    public void addChild();
    public void setLeft(NodeInterface n);
    public void setRight(NodeInterface n);



/*

    */

}