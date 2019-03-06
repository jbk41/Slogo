package commands;
import backend.BackendManager;

public class UserDefinedCommand extends GeneralCommand {


    private int maxArgs;
    private String myCommandName;

    public UserDefinedCommand(BackendManager bm, String commandName, GeneralCommand vars, GeneralCommand commands){
        super(bm);
        myType = "UserDefined";
        myMaxChildren = 2;
        setMaxArgs();
        myChildren.add(vars);
        myChildren.add(commands);
    }

    public UserDefinedCommand(GeneralCommand c){
        super(c);
    }

    public int getMaxArgs(){
        return maxArgs;
    }

    public String getCommandName(){
        return myCommandName;
    }

    private void setMaxArgs(){
        GeneralCommand v = myChildren.get(0);
        if (v instanceof ListStartCommand){
            ListStartCommand vars = (ListStartCommand) v;
            maxArgs = vars.getNumActualChildren();
        }
        else {
            //TODO: throw error
        }
    }

    public void execute() {
        myBM.addUserDefinedCommand(this);
    }
}
