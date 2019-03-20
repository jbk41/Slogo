package commands;

/**
 * This Class is no longer used in the project but will be kept for documentation reasons.
 */


public class TurtleCommand {
    private boolean penUp;
    private boolean jump;
    private double degrees;
    private double displacement;
    private boolean invisible;

    public TurtleCommand(){
        penUp = false;
        jump = false;
        degrees = 0.0;
        displacement = 0.0;
        invisible = false;
    }



    public void setPenUp(boolean penUp){this.penUp = penUp;}
    public void setJump(boolean jump){this.jump = jump;}
    public void setDegrees(double degrees){this.degrees = degrees;}
    public void setDisplacement(double displacement){this.displacement = displacement;}
    public void setInvisible(boolean invisible){this.invisible = invisible;}

    public Boolean getPenUp() {
        return penUp;
    }

    public Boolean getJump() {
        return jump;
    }

    public Double getDegrees() {
        return degrees;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public Boolean getInvisible() {
        return invisible;
    }
}
