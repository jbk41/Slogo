package commands;

import Executable.Executable;
import backend.BackendManager;

public class ForCommand extends GeneralCommand {

    final String REQUIRED_LIST = "For loops requires two lists as parameters";
    final int CONDITION_INDEX = 0;
    final int EXECUTE_INDEX = 1;

    final int VAR_INDEX = 0;
    final int START_INDEX = 1;
    final int END_INDEX = 2;
    final int STEP_INDEX = 3;
    public ForCommand(BackendManager bm){
        super(bm);
        setType("For");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand conditionCommand = getChildren().get(CONDITION_INDEX);
        GeneralCommand executeCommand = getChildren().get(EXECUTE_INDEX);
        if (!(conditionCommand instanceof ListStartCommand && executeCommand instanceof ListStartCommand)){
            getBM().throwError(REQUIRED_LIST, getLineNumber());
            return;
        }
        VariableCommand var = (VariableCommand) conditionCommand.getChildren().get(VAR_INDEX);
        double start = conditionCommand.getChildren().get(START_INDEX).getVal();
        double end = conditionCommand.getChildren().get(END_INDEX).getVal();
        double step = conditionCommand.getChildren().get(STEP_INDEX).getVal();

        for (double i = start; i < end; i += step){
            getBM().setVariable(var.getVarName(), i);
            executeCommand.execute();
            setVal(i);
        }
    }
}
