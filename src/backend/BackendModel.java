package backend;
import TurtleState.TurtleCommand;
import TurtleState.TurtleManager;
import parser.ParseCleaner;
import commands.GeneralCommand;

import java.util.ArrayList;

public class BackendModel implements BackendAPI {


    private BackendManager myBM;
    private CommandManager myCM;
    private VariableManager myVM;
    private CommandTree myCT;
    private ParseCleaner myPC;
    private TurtleManager myTM;

    public BackendModel(){
        myCM = new CommandManager();
        myVM = new VariableManager();
        myTM = new TurtleManager(myCM);
        myBM = new BackendManager(myCM, myVM, myTM);
    }

    public void setLanguage(String language){
        myPC = new ParseCleaner(language);
    }

    public CommandTree interpret(String text){
        myCT = new CommandTree(text, myPC, myBM);
        return myCT;
    }

    public BackendManager getBackendManager(){
        return myBM;
    }

    public TurtleManager getTurtleManager() { return myTM; }

    public void printTree(){
        myCT.printTree();
    }



}
