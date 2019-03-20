package backend;

import Executable.Executable;
import parser.ParseCleaner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface BackendAPI {

    /**
     * Sets the language of the User Interface
     * @param language
     */
    public void setLanguage(String language);

    /**
     * Parses the text inputed by the user. This method creates a CommandTree, which then is updated, and then creates and Executable
     * of its corresponding type.
     * @param text - the user input text.
     */
    public void interpret(String text);

    /**
     * Clears the CommandList whenever the user hits play.
     */
    public void clearCommandList();

    /**
     * Returns the Variable Map from VariableManager. The map contains all the variables set by the user and its
     * corresponding values.
     */
    public Map<String, Double> getVarMap();

    /**
     * Adds an entry to the Variable Map.
     * @param key - variable name
     * @param val - variable value
     */
    public void setVariable(String key, double val);

    /**
     * Returns a List of executables to visualize appropriately. Executables are created from the text after it
     * is parsed by the backend.
     * @return
     */
    public List<Executable> getCommands();

    /**
     * Sets the new environment color to value of backgroundIndex
     * @param backgroundIndex
     */
    public void setBackgroundIndex(double backgroundIndex);

    /**
     * Sets the penColor to value of colorIndex
     * @param colorIndex
     */
    public void setColorIndex(double colorIndex);

    /**
     * Sets pen size to the value of penSize
     * @param penSize
     */
    public void setPenSize(double penSize);

    /**
     * Sets shape of turtle to the value of shapeIndex
     * @param shapeIndex
     */
    public void setShapeIndex(double shapeIndex);
}
