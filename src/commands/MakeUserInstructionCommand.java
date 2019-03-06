package commands;
import backend.BackendManager;

public class MakeUserInstructionCommand extends GeneralCommand {


    public MakeUserInstructionCommand(BackendManager bm) {
        super(bm);
        myMaxChildren = 2;
        myType = "MakeUserInstruction";
    }

    public void execute(){
        GeneralCommand userCommand = myChildren.get(0);
        GeneralCommand vars = myChildren.get(1);
        GeneralCommand commands = myChildren.get(2);
        String commandName = "";
        if (userCommand instanceof UndefinedCommand){
            UndefinedCommand newCommand = (UndefinedCommand) userCommand;
            commandName = newCommand.getCommandName();
        }
        else {
            //TODO throw an error. user command should not be in the list of standard commands
        }

        myBM.addUserCommand(commandName, this);
    }



}
