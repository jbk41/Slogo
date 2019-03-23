package Executable;

/**
 * Contains the states of the Environment such as pen color and canvas color.
 * @author Justin
 */
public class EnvironmentState extends Executable{

    private double backgroundIndex;
    private double colorIndex;
    private double penSize;
    private double shapeIndex;

    /**
     * Creates an object that holds environment states with the given configurations.
     * @param backgroundIndex
     * @param colorIndex
     * @param penSize
     * @param shapeIndex
     */
    public EnvironmentState(double backgroundIndex, double colorIndex, double penSize, double shapeIndex){
        this.backgroundIndex = backgroundIndex;
        this.colorIndex = colorIndex;
        this.penSize = penSize;
        this.shapeIndex = shapeIndex;
    }

    /**
     * Initializes an EnvironmentState object with default values.
     */
    public EnvironmentState(){
        this.backgroundIndex = 0;
        this.colorIndex = 0;
        this.penSize = 1;
        this.shapeIndex = 0;
    }

    /**
     * Get the background index of the current EnvironmentState.
     * @return
     */
    public double getBackgroundIndex() {
        return backgroundIndex;
    }

    /**
     * Get the color index of the current EnvironmentState.
     * @return
     */
    public double getColorIndex(){
        return colorIndex;
    }

    /**
     * Get the current pen size of the environment.
     * @return
     */
    public double getPenSize(){
        return penSize;
    }

    /**
     * Get the index of the shape the turtles are being represented by.
     * @return
     */
    public double getShapeIndex(){
        return shapeIndex;
    }

    /**
     * Sets the background index.
     * @param backgroundIndex
     */
    public void setBackgroundIndex(double backgroundIndex) {
        this.backgroundIndex = backgroundIndex;
    }

    /**
     * Sets the color index.
     * @param colorIndex
     */
    public void setColorIndex(double colorIndex) {
        this.colorIndex = colorIndex;
    }

    public void setPenSize(double penSize) {
        this.penSize = penSize;
    }

    /**
     * Sets the shape index
     * @param shapeIndex
     */
    public void setShapeIndex(double shapeIndex) {
        this.shapeIndex = shapeIndex;
    }

    @Override
    public String toString(){
        return "Change in environment";
    }
}
