package commands;

import Executable.Executable;
import backend.BackendManager;

public class ForCommand extends GeneralCommand {

    public ForCommand(BackendManager bm){
        super(bm);
        setType("For");
        setMaxChildren(2);
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand conditionCommand = getChildren().get(0);
        GeneralCommand executeCommand = getChildren().get(1);
        if (!(conditionCommand instanceof ListStartCommand && executeCommand instanceof ListStartCommand)){
            getBM().throwError("For loops requires two lists as parameters", getLineNumber());
            return;
        }
        VariableCommand var = (VariableCommand) conditionCommand.getChildren().get(0);
        double start = conditionCommand.getChildren().get(1).getVal();
        double end = conditionCommand.getChildren().get(2).getVal();
        double step = conditionCommand.getChildren().get(3).getVal();

        for (double i = start; i < end; i += step){
            getBM().setVariable(var.getVarName(), i);
            executeCommand.execute();
            setVal(i);
        }
    }
}
