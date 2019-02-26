package backend;

import TurtleState.TurtleCommand;
import parser.ParseCleaner;


public class TestClass {

    /**
     * Just switch between the 4 different INPUT_TEXT to test the Turtle Command
     */
    static String myLanguage = "English";

    static String INPUT_TEXT = "st";
    //static String INPUT_TEXT = "bacK difference 200 sum 12 % 10 9";
    //static String INPUT_TEXT = "right sum sin 180 difference 20 10";
    //static String INPUT_TEXT = "Left sum 10 random 100 1 10";


    public static void main (String[] args){
        /*
        ParseCleaner myCleaner = new ParseCleaner(myLanguage);
        CommandTree t = new CommandTree(INPUT_TEXT, myCleaner);
        t.printTree();
        TurtleCommand turtle = new TurtleCommand(t.getHead());
        //System.out.println(turtle.getDisplacement());
        //System.out.println(turtle.getDegrees());
        */

        BackendModel backend = new BackendModel();
        backend.setLanguage("English");
        backend.interpret("[ fd 1  fd 2 ] [ fd + 4 5 fd 6 ]");
        backend.printTree();
        System.out.println();

        backend.setLanguage("Chinese");
        backend.interpret("qianjin * -  4 5 6");
        backend.printTree();
        //System.out.println(turtle.getDegrees());
    }
}
