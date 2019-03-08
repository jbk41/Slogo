package Executable;

public class EnvironmentState extends Executable{


    private double backgroundIndex;
    private double colorIndex;
    private double penSize;
    private double shapeIndex;

    public EnvironmentState(double backgroundIndex, double colorIndex, double penSize, double shapeIndex){
        this.backgroundIndex = backgroundIndex;
        this.colorIndex = colorIndex;
        this.penSize = penSize;
        this.shapeIndex = shapeIndex;
    }

    public EnvironmentState(){
        this.backgroundIndex = 0;
        this.colorIndex = 0;
        this.penSize = 1;
        this.shapeIndex = 0;
    }

    public double getBackgroundIndex() {
        return backgroundIndex;
    }

    public double getColorIndex(){
        return colorIndex;
    }

    public double getPenSize(){
        return penSize;
    }

    public double getShapeIndex(){
        return shapeIndex;
    }

    public void setBackgroundIndex(double backgroundIndex) {
        this.backgroundIndex = backgroundIndex;
    }

    public void setColorIndex(double colorIndex) {
        this.colorIndex = colorIndex;
    }

    public void setPenSize(double penSize) {
        this.penSize = penSize;
    }

    public void setShapeIndex(double shapeIndex) {
        this.shapeIndex = shapeIndex;
    }

    @Override
    public String toString(){
        return "Change in environment";
    }
}
