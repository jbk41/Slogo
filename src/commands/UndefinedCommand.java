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

    public UndefinedCommand(GeneralCommand c) {
        super(c);
    }

    public String getCommandName(){

        return myName;
    }
}
