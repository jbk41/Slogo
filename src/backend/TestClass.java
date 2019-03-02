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
        backend.interpret("set :trial 50 fd :trial fd 100 pd rt 30 pu fd 200 bk 20");
        var map = backend.getBackendManager().getVariableManager().getVariableMap();
        for (String key : map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
}
