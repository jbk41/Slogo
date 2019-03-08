package commands;
import backend.BackendManager;

public class UserDefinedCommand extends GeneralCommand {


    private int maxArgs;

    private String myCommandName;

    public UserDefinedCommand(BackendManager bm, String commandName, GeneralCommand vars, GeneralCommand commands){
        super(bm);
        setType("UserDefined");
        setMaxChildren(2);
        setMaxArgs();
        getChildren().add(vars);
        getChildren().add(commands);
    }

    public int getMaxArgs(){
        return maxArgs;
    }

    public String getCommandName(){
        return myCommandName;
    }

    private void setMaxArgs(){
        GeneralCommand v = getChildren().get(0);
        if (v instanceof ListStartCommand){
            ListStartCommand vars = (ListStartCommand) v;
            maxArgs = vars.getNumActualChildren();
        }
        else {
            getBM().throwError("Wrong number of args", getLineNumber());
        }
    }

    public void execute() { getBM().addUserDefinedCommand(this);
    }
}
