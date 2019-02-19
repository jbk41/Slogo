package Parser;
import CommandNode.*;



public class CommandTree {

    private String[] myText;
    private int myTextIndex;
    private Node head;
    private NodeMaker myNM;

    public CommandTree(String text){
        myText = text.split("\\s+");
        myNM = new NodeMaker();
        myTextIndex = 0;
    }

    private void insertHead(){
        head = myNM.makeNode(myText[myTextIndex]);
        myTextIndex++;
    }

    protected void parse(){
        insertHead();
        Node ptr = head;
        while (myTextIndex < myText.length){
            if 
        }

    }

}
