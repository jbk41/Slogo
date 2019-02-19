package Parser;
import CommandNode.Node;
import CommandNode.NodeMaker;

import java.util.ArrayList;


public class CommandTree {

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
    }

    protected void parse(){

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
