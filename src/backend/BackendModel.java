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

    /**
     * Sets the language of the User Interface
     * @param language
     */
    public void setLanguage(String language){
        myPC = new ParseCleaner(language);
    }

    /**
     * Parses the text inputed by the user. This method creates a CommandTree, which then is updated, and then creates and Executable
     * of its corresponding type.
     * @param text - the user input text.
     */
    public void interpret(String text){
        myCT = new CommandTree(text, myPC, myBM);
    }

    /**
     * Clears the CommandList whenever the user hits play.
     */
    public void clearCommandList(){
        myBM.clearCommands();
    }

    /**
     * Returns the Variable Map from VariableManager. The map contains all the variables set by the user and its
     * corresponding values.
     */
    public Map<String, Double> getVarMap(){
        return Collections.unmodifiableMap(myBM.getVarMap());
    }

    /**
     * Adds an entry to the Variable Map.
     * @param key - variable name
     * @param val - variable value
     */
    public void setVariable(String key, double val){
        myBM.setVariable(key, val);
    }

    /**
     * Returns a List of executables to visualize appropriately. Executables are created from the text after it
     * is parsed by the backend.
     * @return
     */
    public List<Executable> getCommands(){
        return myBM.getCommands();
    }

    /**
     * Sets the new environment color to value of backgroundIndex
     * @param backgroundIndex
     */
    public void setBackgroundIndex(double backgroundIndex){
        myBM.getCurrentEnvironment().setBackgroundIndex(backgroundIndex);
    }

    /**
     * Sets the penColor to value of colorIndex
     * @param colorIndex
     */
    public void setColorIndex(double colorIndex){
        myBM.getCurrentEnvironment().setColorIndex(colorIndex);
    }

    /**
     * Sets pen size to the value of penSize
     * @param penSize
     */
    public void setPenSize(double penSize){
        myBM.getCurrentEnvironment().setPenSize(penSize);
    }

    /**
     * Sets shape of turtle to the value of shapeIndex
     * @param shapeIndex
     */
    public void setShapeIndex(double shapeIndex){
        myBM.getCurrentEnvironment().setShapeIndex(shapeIndex);
    }
}
