package commands;

import backend.BackendManager;

public class IfCommand extends GeneralCommand {

    public IfCommand(BackendManager bm){
        super(bm);
        setMaxChildren(2);
        setType("If");
    }

    public void execute(){
        GeneralCommand conditionCommand = getChildren().get(0);
        GeneralCommand executeCommand = getChildren().get(1);

        conditionCommand.execute();

        if (conditionCommand.getVal() != 0){
            executeCommand.execute();
        }
    }
}
