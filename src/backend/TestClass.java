package backend;

import parser.ParseCleaner;
import commands.*;


public class TestClass {

    static String myLanguage = "English";

    public static void main (String[] args){
        ParseCleaner myCleaner = new ParseCleaner(myLanguage);
        String text = "lt sum 1 10";
        CommandTree t = new CommandTree(text, myCleaner);
//        GeneralCommand<?> command = t.getHead();
//
        TurtleCommand turtle = new TurtleCommand(t.getHead());
        System.out.println(turtle.getDisplacement());
        System.out.println(turtle.getDegrees());
    }
}
