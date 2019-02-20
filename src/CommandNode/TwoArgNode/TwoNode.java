package CommandNode.TwoArgNode;
import CommandNode.NodeInterface;
import CommandNode.Node;

public class TwoNode extends Node {

    protected NodeInterface left;
    protected NodeInterface right;

    protected TwoNode(String s){
        super(s);
        myMaxChildren = 2;
        left = null;
        right = null;
    }
}
