package CommandNode.MathNode;

import CommandNode.Node;
import static java.lang.Integer.parseInt;

public class MathTwoArgNode extends Node {

    public void update() {
        if (this.right == null && this.left!= null) {
            int i = parseInt(this.left.value);
            this.value = Integer.toString(i);
        }
        else if(this.right != null && this.left== null) {
            int i = parseInt(this.right.value);
            this.value = Integer.toString(i);
        }
        else {
            int i = parseInt(this.left.value);
            int j = parseInt(this.right.value);
            this.value = Integer.toString(i+j);
        }
    }
}
