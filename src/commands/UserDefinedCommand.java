package commands;
import backend.BackendManager;

public class UserDefinedCommand extends GeneralCommand {


    private int maxArgs;
    private String myCommandName;

    public UserDefinedCommand(BackendManager bm, String commandName){
        super(bm);
        setType("UserDefined");
        myCommandName = commandName;
        setMaxChildren(2);
        //setMaxArgs();
        //getChildren().add(vars);
        //getChildren().add(commands);
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

//    private void setMaxArgs(){
//        GeneralCommand v = getChildren().get(0);
//        if (v instanceof ListStartCommand){
//            ListStartCommand vars = (ListStartCommand) v;
//            maxArgs = vars.getNumActualChildren();
//        }
//        else {
//            getBM().throwError("Wrong number of args", getLineNumber());
//        }
//    }

    /**
     * Executes the vommands. Adds the command to the CommandManager Map.
     */
    public void execute() { getBM().addUserDefinedCommand(myCommandName, this);
    }
}
