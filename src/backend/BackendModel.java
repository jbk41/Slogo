package backend;
import TurtleState.TurtleCommand;
import parser.ParseCleaner;
import commands.GeneralCommand;

import java.util.ArrayList;

public class BackendModel implements BackendAPI {


    private VariableManager myVM;
    private CommandManager myCM;
    private CommandTree myCT;
    private ParseCleaner myPC;

    public BackendModel(){
        myVM = new VariableManager();
        myCM = new CommandManager();
    }

    public void setLanguage(String language){
        myPC = new ParseCleaner(language);
    }

    public CommandTree interpret(String text){
        myCT = new CommandTree(text, myPC, myCM, myVM);
        return myCT;
    }

    public CommandManager getCommandManager(){
        return myCM;
    }

    public void printTree(){
        myCT.printTree();
    }



}
