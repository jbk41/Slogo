package backend;

import TurtleState.TurtleCommand;

import java.util.ArrayList;

public class CommandManager {

    public ArrayList<TurtleCommand> myCommandList;

    public CommandManager(){
        myCommandList = new ArrayList<>();
    }

    public void addToList(TurtleCommand command){
        myCommandList.add(command);
    }

    public void printCommands() {
        for (TurtleCommand tc : myCommandList){
            System.out.println(tc.toString());
        }
    }

}

