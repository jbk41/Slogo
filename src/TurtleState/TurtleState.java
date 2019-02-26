package TurtleState;

public class TurtleState {

    private double myXPos;
    private double myYPos;
    private double myDegrees;
    private boolean isPenDown;
    private boolean isVisible;
    private double myId;

    /**
     * pen down true = 1
     * if its visible = 1
     *
     * We will have arraylist of TurtleState objects that will have a unique tag so we know when theres a new Turtle
     * Object
     *
     *
     * definitive xy
     *
     * make unique identifiers
     *
     *
     * @param
     */

    public TurtleState(double xPos, double yPos, double degrees, double id){
        myXPos = xPos;
        myYPos = yPos;
        myDegrees = degrees;
        isPenDown = false;
        isVisible = false;
        myId = id;
    }



}
