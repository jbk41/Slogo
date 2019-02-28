package backend;

import TurtleState.TurtleCommand;
import parser.ParseCleaner;


public class TestClass {

    public static void main (String[] args){
        BackendModel backend = new BackendModel();
        backend.setLanguage("English");
        backend.interpret("make :hello 50");

    }
}
