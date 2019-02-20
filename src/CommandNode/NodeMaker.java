package CommandNode;



import java.util.Map;
import java.util.HashMap;


public class NodeMaker {
    final Map<String, Node> myMap = new HashMap<> (){{
        put("FD", new ForwardNode());
        put("FORWARD", new ForwardNode());
        /*
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
        */

        put("SUM", new SumNode("sum"));
        put("+", new SumNode("sum"));
        //MATH COMMANDS
        /*

        myMap.put("DIFFERENCE", new SubtractNode());
        myMap.put("-", new SubtractNode());
        myMap.put("PRODUCT", new ProductNode());
        myMap.put("*", new ProductNode());
        myMap.put("QUOTIENT", new QuotientNode());
        myMap.put("/", new QuotientNode());
        myMap.put("REMAINDER", new RemainderNode());
        myMap.put("%", new RemainderNode());
        myMap.put("MINUS", new NegativeNode());
        myMap.put(`~`, new NegativeNdoe());
        myMap.put("RANDOM", new RandomNode());
        myMap.put("SIN", new TrigNode());
        myMap.put("COS", new TrigNode());
        myMap.put("TAN", new TrigNode());
        myMap.put("ATAN", new TrigNode());
        myMap.put("LOG", new LogNode());
        myMap.put("POW", new PowerNode());
        myMap.put("Pi", new PiNode());
        */
        /*

        //BOOLEAN COMMANDS
        myMap.put("LESS?", new LessThanNode());
        myMap.put("LESSP", new LessThanNode());
        myMap.put("GREATER?", new GreaterThanNode());
        myMap.put("GREATERP", new GreaterThanNode());
        myMap.put("EQUAL?", new EqualToNode());
        myMap.put("EQUALP", new EqualToNode());
        myMap.put("NOTEQUAL?", new NotEqualToNode());
        myMap.put("NOTEQUALP", new NotEqualToNode());
        myMap.put("AND", new AndNode());
        myMap.put("OR", new OrNode());
        myMap.put("NOT", new NotNode());

        //TURTLE QUERIES COMMANDS
        myMap.put("XCOR", new XCorNode());
        myMap.put("YCOR", new YCorNode());
        myMap.put("HEADING", new HeadingNode());
        myMap.put("PENDOWN?", new PenNode());
        myMap.put("PENDOWNP", new PenNode());
        myMap.put("SHOWING?", new ShowNode());
        myMap.put("SHOWINGP", new ShowNode());
        */
    }};

    public NodeMaker() {
    }

    public Node makeNode(String s) {
        return myMap.get(s);
    }

}
