package TurtleState;

import commands.GeneralCommand;

public class TurtleCommand {
    private Boolean penDown = false;
    private Boolean jump = false;
    private Double degrees;
    private Double displacement;
    private Boolean visible = true;
    private commands.GeneralCommand Command;

    public TurtleCommand(GeneralCommand command){
        Command = command;
        displacement = compare(command.toString(),"Forward") * command.getVal() + compare(command.toString(), "Backward") * -1.0 * command.getVal();
        degrees = compare(command.toString(),"Right") * command.getVal() + compare(command.toString(), "Left") * -1.0 * command.getVal();
        jump = false;
        setVisible(command.toString());
        setPen(command.toString());
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

    public Boolean getPenDown() {
        return penDown;
    }

    public Boolean getJump() {
        return jump;
    }

    public Boolean getVisible() {
        return visible;
    }

    public String getType(){ return Command.toString(); }

    @Override
    public String toString(){
        return Command.toString(); }
}

