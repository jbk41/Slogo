package commands;

import backend.BackendManager;

public class IfElseCommand extends GeneralCommand{

    public IfElseCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 3;
        myType = "IfElse";
    }

    public IfElseCommand(GeneralCommand c){
        super(c);
    }
    public void execute(){
        GeneralCommand conditionCommand = myChildren.get(0);
        GeneralCommand ifCommand = myChildren.get(1);
        GeneralCommand elseCommand = myChildren.get(2);

        conditionCommand.execute();

        if (conditionCommand.getVal() != 0){
            ifCommand.execute();
        }
        else {
            elseCommand.execute();
        }
    }
}
