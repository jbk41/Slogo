package Parser;

import CommandNode.NodeInterface;
import CommandNode.NodeMaker;

public class CommandTree {
    private String[] myText;
    private int myTextIndex;
    private NodeInterface head;
    private NodeMaker myNM;

    public CommandTree(String text){
        myText = text.split("\\s+");
        myNM = new NodeMaker();
        myTextIndex = 0;
    }
    private void insertHead() {
        head = myNM.makeNode(myText[myTextIndex]);
        myTextIndex++;
    }

    protected void parse(){

    }

    private NodeInterface insert(NodeInterface root){
        if (root == null){
            return getNode();
        }
        int maxChildren = root.getMaxChildren();


        int numChildren = root.getNumChildren();

        if ((maxChildren == 2 || maxChildren == 1) && numChildren == 0){
            root.left = insert(root.left);
        }


    }

    private NodeInterface getNode(){
        int temp = myTextIndex;
        myTextIndex++;
        return myNM.makeNode(myText[temp]);
    }

//

    //private ArrayList<String> myText;
    //private ArrayList<String> myCharList;
    //private NodeMaker myMaker;
    //private Node head;
    //private Node root;

    /*
    public CommandTree(String text){
        myText = makeList(text.split("\\s+"));
        myMaker = new NodeMaker();
        //head = myMaker.getNodeType(myText.get(0));
        //head = new Node();
        myCharList = characterList();
        head = new Node(myText.get(0));
    }
    */





    public static void main(String[] args){
        // Ale,
        // do testing here. When you want to run, go to src and then right click on this file and hit run CommandTree.main()
        //myText.remove(0);

    }


    /*

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
    */
}
