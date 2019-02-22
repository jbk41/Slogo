package backend;

import parser.ParseCleaner;
import parser.Parser;

import java.util.ArrayList;

public class TestClass {

    public ParseCleaner cleaner;
    static String[] Languages = {"English", "Syntax"};

    public static void main (String[] args){
        String text = "fd + + + 1 2 3 4";
        CommandTree t = new CommandTree(text);
        t.printTree();
    }

}
