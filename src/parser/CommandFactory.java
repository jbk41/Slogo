package parser;

import commands.ForwardCommand;
import commands.GeneralCommand;

public class CommandFactory {

    public CommandFactory(){
    }

    public GeneralCommand getCommand(String s) {
        try {
            Object command = Class.forName("commands." + s + "Command").getConstructor().newInstance();
            return (GeneralCommand) command;

        }
        catch (Throwable e){
            System.err.println(e);
        }
        return new ForwardCommand();
    }
}