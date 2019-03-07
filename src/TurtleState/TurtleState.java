package TurtleState;

public class TurtleState extends State{

    private double myXPos;
    private double myYPos;
    private double myDegrees;
    private boolean isPenDown;
    private boolean isVisible;
    private double myID;
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

    public TurtleState(double xPos, double yPos, double degrees, boolean pen, boolean visible, double id, boolean clear){
        myXPos = xPos;
        myYPos = yPos;
        myDegrees = degrees;
        isPenDown = pen;
        isVisible = visible;
        myID = id;
        myClear = clear;
    }

    // constructor for initializing turtle
    public TurtleState(double id){
        myXPos = 0;
        myYPos = 0;
        myDegrees = 0;
        isPenDown = false;
        myID = id;
        myClear = false;
    }

    public double getX(){
        return myXPos;
    }

    public double getY(){
        return myYPos;
    }

    public double getDeg(){
        return myDegrees;
    }

    public double getID(){
        return myID;
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
