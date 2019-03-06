package commands;

<<<<<<< HEAD
import TurtleState.TurtleCommand;
import backend.BackendManager;
import TurtleState.TurtleCommand;

public class SetTowardsCommand extends MovementCommand {
    public SetTowardsCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 2;
=======
import backend.BackendManager;

public class SetTowardsCommand extends MovementCommand {

    public SetTowardsCommand (BackendManager bm) {
        super(bm);
        myMaxChildren = 1;
>>>>>>> 5c4c9edd7d778d7cb700690adec99d2936d20f36
        myType = "SetTowards";
    }

    @Override
<<<<<<< HEAD
    public void execute() {
        checkParameterCount();
        executeChildren();
        myVal = myChildren.get(0).getVal();
        TurtleCommand command = new TurtleCommand(this);
        //System.out.println("adding command");
        myBM.getCommandManager().addToList(command);
=======
    protected void update() {
        myBM.setTowards(myChildren.get(0).getVal(), myChildren.get(1).getVal());
>>>>>>> 5c4c9edd7d778d7cb700690adec99d2936d20f36
    }
}
