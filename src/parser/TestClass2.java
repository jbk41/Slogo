package parser;

import backend.CommandTree;
import commands.*;

public class TestClass2 {

    public static String[] LANGUAGES = {"English", "French", "Syntax"};
    public static String TEXT = "fd + + + 1 2 3 4";
    public static ParseCleaner CLEANER;

    public static void main (String[] args){
        CLEANER = new ParseCleaner(LANGUAGES);
        CommandTree t = new CommandTree(TEXT, CLEANER);
        t.printTree();
        ForwardCommand f = (ForwardCommand) t.getHead();
        System.out.println(f.getVar());
    }

}