package backend;

import parser.ParseCleaner;
import commands.*;


public class TestClass {

    static String[] myLanguages = {"English"};

    public static void main (String[] args){
        ParseCleaner myCleaner = new ParseCleaner(myLanguages);
        String text = "fd / 6 3";
        CommandTree t = new CommandTree(text, myCleaner);
        t.printTree();
        ForwardCommand f = (ForwardCommand) t.getHead();
        System.out.println(f.getVar());
    }
}
