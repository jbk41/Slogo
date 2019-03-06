package commands;

import backend.BackendManager;

public class IfCommand extends GeneralCommand {

    public IfCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 2;
        myType = "If";
    }

    public IfCommand(GeneralCommand c){
        super(c);
    }
    public void execute(){
        GeneralCommand conditionCommand = myChildren.get(0);
        GeneralCommand executeCommand = myChildren.get(1);

        conditionCommand.execute();

        if (conditionCommand.getVal() != 0){
            executeCommand.execute();
        }
    }
}
