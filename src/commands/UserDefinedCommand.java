package commands;
import backend.BackendManager;

public class UserDefinedCommand extends GeneralCommand {

    private GeneralCommand commandTree;

    public UserDefinedCommand(BackendManager bm, String commandName){
        super(bm);
        myType = "UserDefined";
        myMaxChildren = 0;
        commandTree = myBM.getUserCommand(commandName);
    }

    public UserDefinedCommand(GeneralCommand c){
        super(c);
    }

    public void execute(){
        commandTree.execute();
    }
}
