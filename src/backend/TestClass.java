package backend;

import TurtleState.TurtleCommand;
import parser.ParseCleaner;


public class TestClass {

    public static void main (String[] args){
        BackendModel backend = new BackendModel();
        backend.setLanguage("English");
        backend.interpret("make :hello 50 set :hello 80  set :hi 30 fd :hi");
        var map = backend.getBackendManager().getVariableManager().getVariableMap();
        for (String key : map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
}
