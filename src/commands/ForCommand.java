package commands;

import backend.BackendManager;

public class ForCommand extends GeneralCommand {

    public ForCommand(BackendManager bm){
        super(bm);
        setType("For");
        setMaxChildren(2);
    }

    public void execute(){
        GeneralCommand conditionCommand = getChildren().get(0);
        GeneralCommand executeCommand = getChildren().get(1);

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
