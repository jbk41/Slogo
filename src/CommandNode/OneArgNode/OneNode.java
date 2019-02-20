package CommandNode.OneArgNode;

import CommandNode.Node;
import CommandNode.NodeInterface;

public class OneNode extends Node {
    protected NodeInterface left;

    public OneNode(String s){
        super(s);
        myMaxChildren = 1;
    }
}
