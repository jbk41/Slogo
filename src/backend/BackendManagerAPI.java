package backend;

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

}
