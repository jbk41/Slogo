package backend;
import TurtleState.TurtleCommand;
import TurtleState.TurtleState;
import parser.ParseCleaner;

import java.util.ArrayList;

public class BackendModel implements BackendAPI {

    final static String DEFAULT_LANGUAGE = "English";

    private BackendManager myBM;
    private CommandTree myCT;
    private ParseCleaner myPC;
    private TurtleManager myTM;

    public BackendModel(){
        myBM = new BackendManager();
        myPC = new ParseCleaner(DEFAULT_LANGUAGE);

    }

    public void setLanguage(String language){

        myPC = new ParseCleaner(language);
    }

    public void interpret(String text){
        myCT = new CommandTree(text, myPC, myBM);
    }
    public ArrayList<TurtleState> getCommands(){return myBM.getCommands();}

    public BackendManager getBackendManager(){
        return myBM;
    }s

    public CommandManager getCommandManager(){
        return myCM;
    }

    public TurtleManager getTurtleManager() { return myTM; }


//    public void printTree(){
//        myCT.printTree();
//    }



}
