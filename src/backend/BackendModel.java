package backend;

import Executable.*;
import parser.ParseCleaner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BackendModel implements BackendAPI {

    final String DEFAULT_LANGUAGE = "English";

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

    public void clearCommandList(){
        myBM.clearCommands();
    }

    public Map<String, Double> getVarMap(){
        return Collections.unmodifiableMap(myBM.getVarMap());
    }

    public void setVariable(String key, double val){
        myBM.setVariable(key, val);
    }

    public List<Executable> getCommands(){
        return myBM.getCommands();
    }

    public void setBackgroundIndex(double backgroundIndex){
        myBM.getCurrentEnvironment().setBackgroundIndex(backgroundIndex);
    }

    public void setColorIndex(double colorIndex){
        myBM.getCurrentEnvironment().setColorIndex(colorIndex);
    }

    public void setPenSize(double penSize){
        myBM.getCurrentEnvironment().setPenSize(penSize);
    }

    public void setShapeIndex(double shapeIndex){
        myBM.getCurrentEnvironment().setShapeIndex(shapeIndex);
    }
}
