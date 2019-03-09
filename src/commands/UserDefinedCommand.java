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

    public void setVariables(GeneralCommand vars){
        getChildren().add(vars);
    }
    public void setCommands(GeneralCommand commands){
        getChildren().add(commands);
    }

    public int getMaxArgs(){
        return maxArgs;
    }

    public String getCommandName(){
        return myCommandName;
    }

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

    public void execute() { getBM().addUserDefinedCommand(myCommandName, this);
    }
}
