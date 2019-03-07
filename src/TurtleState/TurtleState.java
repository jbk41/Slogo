package TurtleState;

public class TurtleState {

    private double myXPos;
    private double myYPos;
    private double myDegrees;
    private boolean isPenDown;
    private boolean isVisible;
    private int myId;
    private boolean myClear;

    /**
     * pen down true = 1
     * if its visible = 1
     *
     * We will have arraylist of TurtleState objects that will have a unique tag so we know when theres a new Turtle
     * Object
     *cre
     *
     * definitive xy
     *
     * make unique identifiers
     *
     *
     * @param
     */

    public TurtleState(double xPos, double yPos, double degrees, boolean pen, boolean visible, int id, boolean clear){
        myXPos = xPos;
        myYPos = yPos;
        myDegrees = degrees;
        isPenDown = pen;
        isVisible = visible;
        myId = id;
        myClear = clear;
    }

    // constructor for initializing turtle
    public TurtleState(int id){
        myXPos = 0;
        myYPos = 0;
        myDegrees = 0;
        isPenDown = false;
        myId = id;
        myClear = false;
    }

    public double getXPos(){
        return myXPos;
    }

    public double getYPos(){
        return myYPos;
    }

    public double getMyDegrees(){
        return myDegrees;
    }

    public boolean getPenDown() { return isPenDown; }

    public int getId(){
        return myId;
    }

    public boolean getPenState(){
        return isPenDown;
    }

    public boolean getVisibility(){
        return isVisible;
    }

    public void setPenState(boolean state){
        isPenDown = state;
    }

    public void setVisibility(boolean state){
        isVisible = state;
    }

    public boolean getClear() { return myClear; }

}
