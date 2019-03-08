package commands;

import backend.BackendManager;

public class DoTimesCommand extends GeneralCommand {

    public DoTimesCommand(BackendManager bm){
        super(bm);
        setType("DoTimes");
        setMaxChildren(2);
    }

    public void execute(){
        GeneralCommand conditionCommand = getChildren().get(0);
        GeneralCommand executeCommand = getChildren().get(1);

        double numTimes = conditionCommand.getChildren().get(1).getVal();
        VariableCommand var = (VariableCommand) conditionCommand.getChildren().get(0);

        for (double i = 1; i < numTimes; i++){
            getBM().setVariable(var.getVarName(), i);
            executeCommand.execute();
            setVal(i);
        }
    }
}
