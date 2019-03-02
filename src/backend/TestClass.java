package backend;

import TurtleState.TurtleCommand;
import Visualization.TextEditor;
import parser.ParseCleaner;


public class TestClass {

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
        backend.interpret("fd 100 pd rt 30 fd 200 pu bk 25");
        var map = backend.getBackendManager().getVariableManager().getVariableMap();
//        for (String key : map.keySet()){
//            System.out.println(key);
//            System.out.println(map.get(key));
//        }
    }
}
