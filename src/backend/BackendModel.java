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
    }

    public void setLanguage(String language){
        myPC = new ParseCleaner(language);
    }

    public void interpret(String text){
        myBM = new BackendManager(myCM, myVM);
        myCT = new CommandTree(text, myPC, myBM);
        myTM = new TurtleManager(myBM.getCommandManager());
    }

    public BackendManager getBackendManager(){
        return myBM;
    }

    public TurtleManager getTurtleManager() { return myTM; }

//    public void printTree(){
//        myCT.printTree();
//    }



}
