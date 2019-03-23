package commands;

import backend.BackendManager;

/**
 * If else command. Executes the first list of commands if one condition is held, otherwise, executes the second list.
 * @author Justin
 */
public class IfElseCommand extends GeneralCommand{


    final int CONDITION_INDEX = 0;
    final int IF_INDEX = 1;
    final int ELSE_INDEX = 2;

    public IfElseCommand(BackendManager bm){
        super(bm);
        setMaxChildren(3);
        setType("IfElse");
    }

    /**
     * Executes the first list of commands if one condition is held, otherwise, executes the second list.
     */
    public void execute(){
        GeneralCommand conditionCommand = getChildren().get(CONDITION_INDEX);
        GeneralCommand ifCommand = getChildren().get(IF_INDEX);
        GeneralCommand elseCommand = getChildren().get(ELSE_INDEX);

        if (!(ifCommand instanceof ListStartCommand && elseCommand instanceof ListStartCommand)){
            getBM().throwError("IfElse requires two lists as parameters", getLineNumber());
            return;
        }
        conditionCommand.execute();

        if (conditionCommand.getVal() != 0){
            ifCommand.execute();
        }
        else {
            elseCommand.execute();
        }
    }
}
