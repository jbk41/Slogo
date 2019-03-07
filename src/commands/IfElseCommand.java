package commands;

import backend.BackendManager;

public class IfElseCommand extends GeneralCommand{

    public IfElseCommand(BackendManager bm){
        super(bm);
        setMaxChildren(3);
        setType("IfElse");
    }

    public void execute(){
        GeneralCommand conditionCommand = getChildren().get(0);
        GeneralCommand ifCommand = getChildren().get(1);
        GeneralCommand elseCommand = getChildren().get(2);

        conditionCommand.execute();

        if (conditionCommand.getVal() != 0){
            ifCommand.execute();
        }
        else {
            elseCommand.execute();
        }
    }
}
