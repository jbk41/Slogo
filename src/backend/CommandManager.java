package backend;

import commands.UserDefinedCommand;

import java.util.Map;
import java.util.HashMap;

public class CommandManager {
    private Map<String, UserDefinedCommand> userCommands;

    public CommandManager(){
        userCommands = new HashMap<>();
    }

    public void addCommand(String name, UserDefinedCommand command){
        userCommands.put(name, command);
    }

    public UserDefinedCommand getCommand(String commandName){
        return userCommands.get(commandName);
    }

    public boolean containsCommand(String commandName){
        return userCommands.containsKey(commandName);
    }

    public void setMaxArgs(String commandName, int args){
        userCommands.get(commandName).setMaxArgs(args);
    }
}

