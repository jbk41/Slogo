package backend;

import commands.*;

public class TurtleCommand {
    private Boolean penUp = false;
    private Boolean jump;
    private Double degrees;
    private Double displacement;
    private Boolean invisible;

    public TurtleCommand(GeneralCommand command){
        displacement = compare(command.getType(),"Forward") * command.getVar() + compare(command.getType(), "Backward") * -1.0 * command.getVar();
        degrees = compare(command.getType(),"Right") * command.getVar() + compare(command.getType(), "Left") * -1.0 * command.getVar();
        jump = false;
        invisible = false;
        penUp = false;
    }


    private double compare(String a, String b) {
        if (a.equals(b)) return 1.0;
        else return 0.0;
    }

    public void setDisplacement(Double displacement){this.displacement = displacement;}

    public void setDegrees(Double degrees){this.degrees = degrees;}

    public void setPenUp(Boolean penUp){this.penUp = penUp;}

    public void setJump(Boolean jump){this.jump = jump;}

    public void setInvisible(Boolean invisible){this.invisible = invisible;}



    public Double getDisplacement() {
        return displacement;
    }

    public Double getDegrees() {
        return degrees;
    }

    public Boolean getPenUp() {
        return penUp;
    }

    public Boolean getJump() {
        return jump;
    }


    public Boolean getInvisible() {
        return invisible;
    }
}

