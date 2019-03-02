package TurtleState;

import commands.GeneralCommand;

public class TurtleCommand {
    private int penDown = 0;
    private boolean jump = false;
    private double degrees;
    private double displacement;
    private boolean visible = true;
    private commands.GeneralCommand Command;

    public TurtleCommand(GeneralCommand command){
        Command = command;
        displacement = compare(command.toString(),"Forward") * command.getVal() + compare(command.toString(), "Backward") * -1.0 * command.getVal();
        degrees = compare(command.toString(),"Right") * command.getVal() + compare(command.toString(), "Left") * -1.0 * command.getVal() + compare(command.toString(), "SetHeading") * command.getVal();;
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
        if (type.equals("PenDown")) penDown = 1;
        else if (type.equals("PenUp")) penDown = 2;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public Double getDegrees() {
        return degrees;
    }

    public int getPenDown() { return penDown; }

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

