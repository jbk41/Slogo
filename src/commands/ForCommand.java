package commands;

import backend.BackendManager;

public class ForCommand extends GeneralCommand {

    public ForCommand(BackendManager bm){
        super();
        myType = "For";
        myMaxChildren = 2;
    }

    public void execute(){
        GeneralCommand conditionCommand = myChildren.get(0);
        GeneralCommand executeCommand = myChildren.get(1);

        VariableCommand var = (VariableCommand) conditionCommand.getChildren().get(0);
        double start = conditionCommand.getChildren().get(1).getVal();
        double end = conditionCommand.getChildren().get(2).getVal();
        double step = conditionCommand.getChildren().get(1).getVal();

        for (int i = (int) start; i < (int) end; i += (int) step){
            var.setValue((double) i);
            executeCommand.execute();
            myVal = start;
        }
    }
}
