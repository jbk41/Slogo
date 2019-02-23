package Commands;

public class TurtleCommand {
    private Boolean penUp;
    private Boolean jump;
    private Double degrees;
    private Double displacement;
    private Boolean invisible;

    public TurtleCommand(){
        penUp = false;
        jump = false;
        degrees = 0.0;
        displacement = 0.0;
        invisible = false;
    }
    public void setPenUp(Boolean penUp){this.penUp = penUp;}
    public void setJump(Boolean jump){this.jump = jump;}
    public void setDegrees(Double degrees){this.degrees = degrees;}
    public void setDisplacement(Double displacement){this.displacement = displacement;}
    public void setInvisible(Boolean invisible){this.invisible = invisible;}

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
