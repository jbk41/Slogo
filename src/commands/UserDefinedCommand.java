package commands;
import backend.BackendManager;

/**
 * A command that is not recognized by the resources bundle.
 * @author Justin and Ale
 */
public class UserDefinedCommand extends GeneralCommand {

    private int maxArgs;
    private String myCommandName;

    public UserDefinedCommand(BackendManager bm, String commandName){
        super(bm);
        setType("UserDefined");
        myCommandName = commandName;
    }

    /**
     * Gets the maximum number of arguments for the command
     * @return
     */
    public int getMaxArgs(){
        return maxArgs;
    }

    /**
     * Gets the name of the command
     * @return
     */
    public String getCommandName(){
        return myCommandName;
    }

    /**
     * Sets the max number of arguments of the userdefined commands to be args
     * @param args - max number of user defined commands.
     */
    public void setMaxArgs(int args){
        maxArgs = args;
    }

    /**
     * Executes the vommands. Adds the command to the CommandManager Map.
     */
    public void execute() { getBM().addUserDefinedCommand(myCommandName, this);
    }
}
