package TurtleState;

import commands.*;

public class TurtleCommand { //FIXME: ASK ABOUT CONVENTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private Boolean penDown = false;
    private Boolean jump;
    private Double degrees;
    private Double displacement;
    private Boolean visible = true;

    public TurtleCommand(GeneralCommand command){
        displacement = compare(command.getType(),"Forward") * command.getVar() + compare(command.getType(), "Backward") * -1.0 * command.getVar();
        degrees = compare(command.getType(),"Right") * command.getVar() + compare(command.getType(), "Left") * -1.0 * command.getVar();
        jump = false;
        setVisible(command.getType());
        setPen(command.getType());
    }

    private void setVisible(String type) {
        if (type.equals("ShowTurtle")) visible = true;
        else if (type.equals("HideTurtle")) visible = false;
    }


    private double compare(String a, String b) {
        if (a.equals(b)) return 1.0;
        else return 0.0;
    }

    private void setPen(String type) {
        if (type.equals("PenDown")) penDown = true;
        else if (type.equals("PenUp")) penDown = false;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public Double getDegrees() {
        return degrees;
    }

    public Boolean getPenUp() {
        return penDown;
    }

    public Boolean getJump() {
        return jump;
    }


    public Boolean getVisible() {
        return visible;
    }
}

