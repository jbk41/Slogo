package backend;

import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VariableManager {

    private Map<String, Double> variableMap;

    public VariableManager(){
        variableMap = new HashMap<String, Double>();
    }

    public void set(String varName, double val){
        variableMap.put(varName, val);
    }

    public boolean contains(String varName){
        return variableMap.containsKey(varName);
    }

    public double getVal(String varName){
        return variableMap.get(varName);
    }

    public Map<String, Double> getVariableMap(){
        return Collections.unmodifiableMap(variableMap);
    }
}
