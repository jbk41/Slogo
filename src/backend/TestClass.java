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
<<<<<<< HEAD
        backend.interpret("set :trial 50 fd :trial fd 100 pd rt 30 pu fd 200 bk 20");
=======
        backend.interpret("fd 100 pd rt 30 fd 200 pu bk 25");
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> 46d75890341d5a49aa603c82dc1e62923bfb1624
>>>>>>> cae9756850e477e3464d1795aa713f621e48db8c
        var map = backend.getBackendManager().getVariableManager().getVariableMap();
//        for (String key : map.keySet()){
//            System.out.println(key);
//            System.out.println(map.get(key));
//        }
    }
}
