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
        backend.interpret("fd 4");
        backend.getBackendManager().getCommandManager().printCommands();


////        backend.addCommandList(myCT);
////        System.out.println(myCT.getHead().getChildren());
////        var chuldren = myCT.getHead().getChildren();
////        var myCT = backend.interpret("fd sin 90");




    }
}
