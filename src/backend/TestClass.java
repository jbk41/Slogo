package backend;

import parser.ParseCleaner;

public class TestClass {

    public ParseCleaner cleaner;

    public static void main (String[] args){
        var parser = new ParseCleaner();
        parser.addPatterns("resources/languages/English");
        parser.addPatterns("resources/languages/English");
        String text = "fd + + 1 + 2 3 4";
//        String new_Text = parseText(parser, text);

        CommandTree t = new CommandTree(text);

        //System.out.println("hi");
        t.printTree();
    }

//    public static String parseText (ParseCleaner lang, String text) {
//        String[] new_text = text.split(" ");
//        String finale = new String();
//        for (var s : new_text) {
//                finale = s+" ";
//        }
//        return finale;
//    }
}
