package commands;

import backend.BackendManager;

public class RepeatCommand extends GeneralCommand {

    public RepeatCommand(BackendManager bm){
        super(bm);
        myType = "Repeat";
        myMaxChildren = 2;
    }

    public RepeatCommand(GeneralCommand c){
        super(c);
    }

    public void execute(){
        double numRunTimes;
        myChildren.get(0).execute();
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
