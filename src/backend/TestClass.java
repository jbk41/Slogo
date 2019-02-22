package backend;

import parser.ParseCleaner;
import parser.Parser;

import java.util.ArrayList;

public class TestClass {

    public ParseCleaner cleaner;
    static String[] Languages = {"English", "Syntax"};

    public static void main (String[] args){
        String text = "fd";
        Parser Parse = new Parser(text, Languages);
        var cleanText = Parse.getCleanText();
        CommandTree t = new CommandTree(cleanText);
        t.printTree();
    }

}
