package backend;
import commands.GeneralCommand;
import commands.UserDefinedCommand;
import Executable.*;

import java.util.List;
import java.util.Map;

public interface BackendManagerAPI {

    public void forward(double dist);

    public void backward(double dist);

    public void right(double deg);

    public void setTowards(double x, double y);

    public void setPosition(double x, double y);

    public void penUp();

    public void penDown();

    public void showTurtle();

    public void hideTurtle();

    public void home();

    public void clearScreen();

    public void throwError(String error, int lineNumber);

    public void setVariable(String varName, double val);

    public boolean hasVariable(String varName);

    public double getVariable(String varName);

    public boolean containsCommand(String commandName);

    public void addUserDefinedCommand(String name, UserDefinedCommand userDefinedCommand);

    public UserDefinedCommand getUserCommand(String commandName);

    public void setTurtles(List<Double> turtleIDs);

    public int getNumberActiveTurtles();

    public List<Double> getActiveTurtles();

    public TurtleState getCurrentTurtle();

    public void clearCommands();

    public Map<String, Double> getVarMap();

    public List<Executable> getCommands();

    public void setBackgroundIndex(double backgroundIndex);

    public void setColorIndex(double colorIndex);

    public void setPenSize(double penSize);

    public void setShapeIndex(double shapeIndex);

    public EnvironmentState getCurrentEnvironment();

    public void setColorPaletteEntry(double index, double r, double g, double b);

}
