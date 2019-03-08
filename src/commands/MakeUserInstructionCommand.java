package commands;
import backend.BackendManager;

public class MakeUserInstructionCommand extends GeneralCommand {


    public MakeUserInstructionCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(3);
        setType("MakeUserInstruction");
    }

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
            //TODO throw an error. user command should not be in the list of standard commands
        }

        UserDefinedCommand userDefinedCommand = new UserDefinedCommand(getBM(), commandName, vars, commands);
        //myBM.addUserCommand(commandName, userDefinedCommand);
    }



}