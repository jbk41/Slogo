package commands;

import backend.BackendManager;

public class RepeatCommand extends GeneralCommand {

    public RepeatCommand(BackendManager bm){
        super();
        myType = "Repeat";
        myMaxChildren = 2;
    }

    public void execute(){
        double numRunTimes;
        try {
            numRunTimes = getValFromChild(myChildren.get(0));
        }
        catch (IllegalArgumentException e) {
            return;
        }
        for (int i = 0; i < numRunTimes; i++){
            myChildren.get(1).execute();
        }

    }
}
