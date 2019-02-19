package Parser;
import CommandNode.Node;


public class CommandTree {

    private String[] myText;
    private Node head;

    public CommandTree(String text){
        myText = text.split("\\s+");
    }

    protected void parse(){

    }

}
