package backend;
import commands.GeneralCommand;

import TurtleState.TurtleCommand;
import commands.UserDefinedCommand;

import java.util.Map;
import java.util.HashMap;


import java.util.ArrayList;

public class CommandManager {
    private Map<String, UserDefinedCommand> userCommands;

    public CommandManager(){

        userCommands = new HashMap<>();
    }

    public void addCommand(UserDefinedCommand command){
        String name = command.getCommandName();
        userCommands.put(name, command);
    }

    public UserDefinedCommand getCommand(String commandName){

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

