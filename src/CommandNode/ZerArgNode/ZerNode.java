package CommandNode.ZerArgNode;
import CommandNode.NodeInterface;

public class ZerNode extends NodeInterface {

    public ZerNode(String s){
        super(s);
        myMaxChildren = 0;
    }
}
