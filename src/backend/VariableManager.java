package backend;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;

public class VariableManager {

    private Map<String, Double> variableMap;

    public VariableManager(){
        variableMap = new HashMap<String, Double>();
    }

    public Map<String, Double> getVariableMap() { return variableMap; }
}
