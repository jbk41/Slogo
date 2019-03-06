package backend;
import commands.GeneralCommand;

import TurtleState.TurtleCommand;
import java.util.Map;
import java.util.HashMap;


import java.util.ArrayList;

public class CommandManager {
    private Map<String, GeneralCommand> userCommands;

    public CommandManager(){
        userCommands = new HashMap<>();
    }

    public void addCommand(String commandName, GeneralCommand command){
        userCommands.put(commandName, command);
    }

    public GeneralCommand getCommand(String commandName){
        return userCommands.get(commandName);
    }

    /*
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

    public ArrayList<TurtleCommand> getCommandList() { return myCommandList; }

    public void clearCommandList(){
        myCommandList.clear();
    }
    */

}

