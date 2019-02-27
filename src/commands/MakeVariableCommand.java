package commands;

import backend.BackendManager;

public class MakeVariableCommand extends GeneralCommand {

    public MakeVariableCommand(BackendManager bm){
        super();
        myType = "MakeVariable";
        myMaxChildren = 2;
    }

    public void execute(){
        VariableCommand var = (VariableCommand) myChildren.get(0);
        var.setValue(getValFromChild(myChildren.get(1)));
    }
}
