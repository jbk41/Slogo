package commands;

import backend.BackendManager;

public class DoTimesCommand extends GeneralCommand {

    public DoTimesCommand(BackendManager bm){
        super(bm);
        myType = "DoTimes";
        myMaxChildren = 2;
    }

    public DoTimesCommand(GeneralCommand c){
        super(c);
    }
    public void execute(){
        GeneralCommand conditionCommand = myChildren.get(0);
        GeneralCommand executeCommand = myChildren.get(1);

        double numTimes = conditionCommand.getChildren().get(1).getVal();
        VariableCommand var = (VariableCommand) conditionCommand.getChildren().get(0);

        for (double i = 1; i < numTimes; i++){
            myBM.setVariable(var.getVarName(), i);
            executeCommand.execute();
            myVal = i;
        }
    }
}
