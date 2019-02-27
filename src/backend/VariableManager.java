package backend;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;

public class VariableManager {

    private Map<String, Double> variableMap;

    public VariableManager(){
        variableMap = new HashMap<String, Double>();
    }

    public double getValue(String varName) throws InvalidKeyException {
        if (!variableMap.containsKey(varName)){
            throw new InvalidKeyException(varName + " + has not been initialized");
        }

        return variableMap.get(varName);
    }

    public void setValue(String varName, Double value){
        variableMap.put(varName, value);
    }

}
