package commands;

import backend.BackendManager;

public class DoTimesCommand extends GeneralCommand {

    final String POSITIVE_ERROR = "Number of times run must be positive";
    final String LIST_REQUIRED = "DoTimes requires list as parameter";
    final int START_INDEX = 1;
    final int EXECUTE_INDEX = 1;
    final int VAR_INDEX = 0;

    public DoTimesCommand(BackendManager bm){
        super(bm);
        setType("DoTimes");
        setMaxChildren(2);
    }

    public void execute(){
        GeneralCommand conditionCommand = getChildren().get(VAR_INDEX);
        GeneralCommand executeCommand = getChildren().get(EXECUTE_INDEX);

        double numTimes = conditionCommand.getChildren().get(EXECUTE_INDEX).getVal();
        if (numTimes < 0){
            getBM().throwError(POSITIVE_ERROR, getLineNumber());
            return;
        }
        if (!(executeCommand instanceof ListStartCommand)){
            getBM().throwError(LIST_REQUIRED, getLineNumber());
            return;
        }
        VariableCommand var = (VariableCommand) conditionCommand.getChildren().get(VAR_INDEX);

        for (double i = START_INDEX; i < numTimes; i++){
            getBM().setVariable(var.getVarName(), i);
            executeCommand.execute();
            setVal(i);
        }
    }
}
