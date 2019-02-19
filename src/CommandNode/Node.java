package CommandNode;

public class Node {
    public String value;
    public Node left;
    public Node right;

    public Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }

    public Node(){
        this.value = null;
        right = null;
        left = null;
    }
}