package CommandNode.TwoArgNode;
import CommandNode.NodeInterface;

public class TwoNode extends NodeInterface {

    protected NodeInterface left;
    protected NodeInterface right;

    protected TwoNode(String s){
        super(s);
        myMaxChildren = 2;
        left = null;
        right = null;
    }
}
