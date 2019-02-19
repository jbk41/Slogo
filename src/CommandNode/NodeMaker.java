package CommandNode;

import CommandNode.TurtleNode.TOneArgNode.ForwardNode;

import java.util.ArrayList;
import java.util.Map;


public class NodeMaker {
    private Map<String, Node> myMap;

    public Node NodeMaker(String s) {
        createMap();
        return myMap.get(s);
    }

    private void createMap() {
        myMap = new Map<String, Node>;

        //TURTLE COMMANDS
        myMap.put("FD", new ForwardNode());
        myMap.put("FORWARD", new ForwardNode());
        myMap.put("BK", new BackNode());
        myMap.put("BACK", new BackNode());
        myMap.put("LT", new TurnLeftNode());
        myMap.put("LEFT", new TurnLeftNode());
        myMap.put("RT", new TurnRightNode());
        myMap.put("RIGHT", new TurnRightNode());
        myMap.put("SETH", new SetHeadingNode());
        myMap.put("SETHEADING", new SetHeadingNode());
        myMap.put("GOTO", new GoToNode());
        myMap.put("SETXY", new GoToNode());
        myMap.put("PD", new PenDownNode());
        myMap.put("PENDOWN", new PenDownNode());
        myMap.put("PU", new PenUpNode());
        myMap.put("PENUP", new PenUpNode());
        myMap.put("ST", new ShowTurtleNode());
        myMap.put("SHOWTURTLE", new ShowTurtleNode());
        myMap.put("HT", new HideTurtleNode());
        myMap.put("HIDETURTLE", new HideTurtleNode());
        myMap.put("HOME", new HomeNode());
        myMap.put("CS", new ClearNode());
        myMap.put("CLEARSCREEN", new ClearNode());

        myMap.put("", new ());
        myMap.put("", new ());
        myMap.put("", new ());
        myMap.put("", new ());
        myMap.put("", new ());






    }
}
