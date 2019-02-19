package Parser;
<<<<<<< HEAD
import CommandNode.*;

=======
import CommandNode.Node;
import CommandNode.NodeMaker;

import java.util.ArrayList;
>>>>>>> f737ec43a07c92a3b9e1c54ce4a19076073c094d


public class CommandTree {

<<<<<<< HEAD
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
=======
    private ArrayList<String> myText;
    private ArrayList<String> myCharList;
    private NodeMaker myMaker;
    private Node head;
    private Node root;
    private int counter= 0;

    public CommandTree(String text){
        myText = makeList(text.split("\\s+"));
        myMaker = new NodeMaker();
        //head = myMaker.getNodeType(myText.get(0));
        //head = new Node();
        myCharList = characterList();
        head = new Node(myText.get(0));
>>>>>>> f737ec43a07c92a3b9e1c54ce4a19076073c094d
    }

    protected void parse(){
        insertHead();
        Node ptr = head;
        while (myTextIndex < myText.length){
            if
        }

    }

<<<<<<< HEAD
    public static void main(String[] args){
        // Ale,
        // do testing here. When you want to run, go to src and then right click on this file and hit run CommandTree.main()
=======
        myText.remove(0);
        makeTree(myText);

    }

    protected Node addNode(Node curr, String val){
        if (curr == null) {
            return new Node(val);
        }
        if (myCharList.contains(curr.value)){
            curr.left = addNode(curr.left, val);
        }
        else {
            curr.right = addNode(curr.right, val);
        }
        return curr;
    }

    private Node makeTree(ArrayList<String> list){
        for (String s: list){
                root = addNode(root,s);
        }
        return root;
>>>>>>> f737ec43a07c92a3b9e1c54ce4a19076073c094d
    }


    private ArrayList<String> makeList(String[] text) {
        var list = new ArrayList<String>();
        for (String s : text){
            list.add(s);
        }
        return list;
    }

    private ArrayList<String> characterList() {
        var list = new ArrayList<String>();
        //Add other characters here
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        list.add("%");
        list.add("~");
        return list;
    }
}
