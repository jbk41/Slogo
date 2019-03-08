package backend;

import Executable.TurtleState;
import Executable.Executable;

public class TestClass {

    public static void main (String[] args){

        BackendModel backend = new BackendModel();
        backend.setLanguage("English");
        backend.interpret("tell [ 1 2 ] fd 100 rt 90 bk 200");
        for (Executable command : backend.getCommands()) {
            if (command instanceof TurtleState){
                TurtleState command1 = (TurtleState) command;
                System.out.println("X: " + command1.getX());
                System.out.println("Y: " + command1.getY());
                System.out.println("deg: " + command1.getDeg());
                System.out.println("ID: " + command1.getID());
                System.out.println("-----------------");
            }

        }
    }
}
