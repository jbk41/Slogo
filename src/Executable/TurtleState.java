package Executable;

public class TurtleState extends Executable{

    /**
     * @author Bryant Huang, Mark Kang, Justin Kim, Ale Meza
     *
     *This class is used to communicate the positioning and properties of the turtle to the front end for display.
     * One can do so by creating a new TurtleState object and passing this to the front end.
     */

    private double myXPos;
    private double myYPos;
    private double myDegrees;
    private boolean isPenDown;
    private boolean isVisible;
    private double myID;
    private boolean myClear;


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
        isVisible = true;
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

//    @Override
//    public String toString(){
//        System.out.println( "x: " + getX());
//        System.out.println( "y: " + getY());
//        System.out.println( "deg: " + getDeg());
//        System.out.println( "pen: " + getPenState());
//        System.out.println( "visibility: " + getVisibility());
//        System.out.println( "id: " + getID());
//        return "";
//    }

}
