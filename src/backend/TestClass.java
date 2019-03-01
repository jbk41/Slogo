package backend;

import TurtleState.TurtleCommand;
import parser.ParseCleaner;


public class TestClass {

    public static void main (String[] args){
        BackendModel backend = new BackendModel();
        backend.setLanguage("English");
        backend.interpret("fd 100 rt 30 fd 200 bk 20 SetH 25");
        var map = backend.getBackendManager().getVariableManager().getVariableMap();
        for (String key : map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
}
