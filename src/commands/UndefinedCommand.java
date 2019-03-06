package commands;
import backend.BackendManager;

public class UndefinedCommand extends GeneralCommand{

    private String myName;

    public UndefinedCommand(BackendManager bm, String name){
        super(bm);
        myType = "Undefined";
        myMaxChildren = 0;
        myName = name;
    }

    public String getCommandName(){
        return myName;
    }
}
