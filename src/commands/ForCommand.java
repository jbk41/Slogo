package commands;

import backend.BackendManager;

public class ForCommand extends GeneralCommand {

    public ForCommand(BackendManager bm){
        super(bm);
        myType = "For";
        myMaxChildren = 2;
    }

    public ForCommand(GeneralCommand c){
        super(c);
    }
    public void execute(){
        GeneralCommand conditionCommand = myChildren.get(0);
        GeneralCommand executeCommand = myChildren.get(1);

        VariableCommand var = (VariableCommand) conditionCommand.getChildren().get(0);
        double start = conditionCommand.getChildren().get(1).getVal();
        double end = conditionCommand.getChildren().get(2).getVal();
        double step = conditionCommand.getChildren().get(3).getVal();

        for (double i = start; i < end; i += step){
            myBM.setVariable(var.getVarName(), i);
            executeCommand.execute();
            myVal = i;
        }
    }
}
