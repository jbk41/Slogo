package parser;

import backend.CommandTree;
import parser.ParseCleaner;
import commands.*;
import parser.Parser;

import java.util.ArrayList;

public class TestClass2 {

    public static String LANGUAGES = "resources/French";
    public static String TEXT = "fd 1";
    public static ParseCleaner CLEANER;

    public static void main (String[] args){
        CLEANER = new ParseCleaner();
        CLEANER.addPatterns("resources.languages/English");
        CommandTree t = new CommandTree(TEXT, CLEANER);
        t.printTree();
        ForwardCommand f = (ForwardCommand) t.getHead();
        System.out.println(f.getVar());
    }

}