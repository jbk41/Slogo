package backend;

import Executable.Executable;
import parser.ParseCleaner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface BackendAPI {


    public void setLanguage(String language);

    public void interpret(String text);

    public void clearCommandList();

    public Map<String, Double> getVarMap();

    public void setVariable(String key, double val);

    public List<Executable> getCommands();

    public void setBackgroundIndex(double backgroundIndex);

    public void setColorIndex(double colorIndex);

    public void setPenSize(double penSize);

    public void setShapeIndex(double shapeIndex);
}
