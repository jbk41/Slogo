package backend;

import parser.ParseCleaner;
import commands.*;


public class TestClass {

    static String myLanguage = "English";

    public static void main (String[] args){
        ParseCleaner myCleaner = new ParseCleaner(myLanguage);
        String text = "fd sum 1 10";
        CommandTree t = new CommandTree(text, myCleaner);
        t.printTree();
        System.out.println(t.getHead().getType());
        System.out.println(t.getHead().getVar());
    }
}
