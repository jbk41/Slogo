package commands;

import backend.BackendManager;

/**
 * Inverts the value of its input.
 * @author Justin and Ale
 */
public class MinusCommand extends GeneralCommand{

    final int FIRST_INDEX = 0;
    final int SECOND_INDEX = 1;

    public MinusCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(1);
        setType("Minus");
    }

    /**
     * Executes the command: sets the val to the opposite of the input
     */
    public void execute(){
        checkParameterCount();
        executeChildren();
        setVal(getChildren().get(0).getVal()*-1);
    }
}
