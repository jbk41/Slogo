package backend;
import TurtleState.TurtleCommand;
import TurtleState.TurtleState;
import parser.ParseCleaner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BackendModel implements BackendAPI {

    final static String DEFAULT_LANGUAGE = "English";

    private BackendManager myBM;
    private CommandTree myCT;
    private ParseCleaner myPC;

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

    public List<TurtleState> getCommands(){
        return myBM.getCommands();
    }

    public void clearCommandList(){
        myBM.clearCommands();
    }

    public Map<String, Double> getVarMap(){
        return Collections.unmodifiableMap(myBM.getVarMap());
    }

    public void setVariable(String key, double val){
        myBM.setVariable(key, val);
    }

    //public BackendManager getBackendManager(){ return myBM; }

    //public CommandManager getCommandManager(){ return myBM.getCommandManager(); }

    //public TurtleManager getTurtleManager() { return myBM.getTurtleManager(); }

}
