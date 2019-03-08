package backend;

import Executable.TurtleState;
import Executable.Executable;

public class TestClass {

    public static void main (String[] args){

        BackendModel backend = new BackendModel();
        backend.setLanguage("English");
        backend.interpret("fd 100");
        for (Executable command : backend.getCommands()) {
            if (command instanceof TurtleState){
                TurtleState command1 = (TurtleState) command;
                command1.toString();
            }

        }
    }
}
