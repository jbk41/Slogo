package backend;

import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The VariableManager manages the variables set by the user. Has standard methods for getting and setting variable
 * values.
 * @author Justin
 */
public class VariableManager {

    private Map<String, Double> variableMap;

    /**
     * Initializes an empty variable map.
     */
    public VariableManager(){
        variableMap = new HashMap<String, Double>();
    }

    /**
     * Sets the value of varName to val.
     * @param varName
     * @param val
     */
    public void set(String varName, double val){
        variableMap.put(varName, val);
    }

    /**
     * Returns true if the variable map contains varName.
     * @param varName
     * @return
     */
    public boolean contains(String varName){
        return variableMap.containsKey(varName);
    }

    /**
     * Gets the value of varName
     * @param varName
     * @return
     */
    public double getVal(String varName){
        return variableMap.get(varName);
    }

    /**
     * Returns an unmodifiable copy of the variableMap.
     * @return
     */
    public Map<String, Double> getVariableMap(){
        return Collections.unmodifiableMap(variableMap);
    }
}
