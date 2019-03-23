package commands;

import backend.BackendManager;

/**
 * Executes a list of commands if their first child holds a certain condition.
 * @author Justin
 */
public class IfCommand extends GeneralCommand {

    final int CONDITION_INDEX = 0;
    final int EXECUTE_INDEX = 1;

    public IfCommand(BackendManager bm){
        super(bm);
        setMaxChildren(2);
        setType("If");
    }

    /**
     * Executes the list commands if a certain condition is met by the first child.
     */
    public void execute(){
        GeneralCommand conditionCommand = getChildren().get(CONDITION_INDEX);
        GeneralCommand executeCommand = getChildren().get(EXECUTE_INDEX);
        if (!(executeCommand instanceof ListStartCommand)){
            getBM().throwError("If requires list parameter", getLineNumber());
        }
        conditionCommand.execute();

        if (conditionCommand.getVal() != 0){
            executeCommand.execute();
        }
    }
}
