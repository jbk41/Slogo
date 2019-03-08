package backend;
import commands.GeneralCommand;
import commands.UserDefinedCommand;

public interface BackendManagerAPI {

    public void forward(double val);

    public void backward(double val);

    public void left(double deg);

    public void right(double deg);

    public void setHeading(double deg);

    public void setTowards(double x, double y);

    public void setPosition(double x, double y);

    public void penUp();

    public void penDown();

    public void showTurtle();

    public void hideTurtle();

    public void home();

    public void clearScreen();

    public boolean containsCommand(String key);

    public void addUserDefinedCommand(UserDefinedCommand userDefinedCommand);

    public UserDefinedCommand getUserCommand(String commandName);

    public void setVariable(String varName, double val);

    public double getVariable(String varName);

    public boolean hasVariable(String varName);
}