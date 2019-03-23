package backend;

import commands.UserDefinedCommand;

import java.util.Map;
import java.util.HashMap;

/**
 * Manages user defined commands. Both creates and calls them.
 * @author Justin
 */
public class CommandManager {
    private Map<String, UserDefinedCommand> userCommands;

    public CommandManager(){
        userCommands = new HashMap<>();
    }

    /**
     * Adds User-Deefined Command and its instruction to the user-Command Map
     * @param name - name of user-dsefined command
     * @param command - instruction of user-defined command
     */
    public void addCommand(String name, UserDefinedCommand command){
        userCommands.put(name, command);
    }

    /**
     * Returns the instruction of the user-defined command from the Map of User-defined COmmands
     * @param commandName - Name of User-defined command
     */
    public UserDefinedCommand getCommand(String commandName){
        return userCommands.get(commandName);
    }

    /**
     * Checks if command is in Map of User-defined commands. If so, then true.
     * @param commandName - Name of user-defined command
     * @return
     */
    public boolean containsCommand(String commandName){
        return userCommands.containsKey(commandName);
    }

    /**
     * Sets the maximum number of arguments for that command within the map.
     * @param commandName - name of user defined command
     * @param args - maximum number of arguments to set
     */
    public void setMaxArgs(String commandName, int args){
        userCommands.get(commandName).setMaxArgs(args);
    }
}

