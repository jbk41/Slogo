package commands;
import backend.BackendManager;

/**
 * Makes a user defined command.
 * @author Justin
 */
public class MakeUserInstructionCommand extends GeneralCommand {

    public MakeUserInstructionCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(3);
        setType("MakeUserInstruction");
    }

    /**
     * Looks at the variables in the first list to define how many arguments the command can take and then
     * saves the commands in the second list. Puts this command in the map of user defined commands in the backendmanager.
     */
    public void execute(){
        GeneralCommand userCommand = getChildren().get(0);
        GeneralCommand vars = getChildren().get(1);
        GeneralCommand commands = getChildren().get(2);
        String commandName = "";
        if (userCommand instanceof UndefinedCommand){
            UndefinedCommand newCommand = (UndefinedCommand) userCommand;
            commandName = newCommand.getCommandName();
        }
        else {
            getBM().throwError("Command name already in use", getLineNumber());
            return;
        }

        UserDefinedCommand ud = getBM().getUserCommand(commandName);
        ud.addChild(vars);
        ud.addChild(commands);
    }

}
