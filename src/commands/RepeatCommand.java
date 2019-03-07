package commands;

import backend.BackendManager;

public class RepeatCommand extends GeneralCommand {

    public RepeatCommand(BackendManager bm){
        super(bm);
        setType("Repeat");
        setMaxChildren(2);
    }

    public void execute(){
        double numRunTimes;
        getChildren().get(0).execute();
        try {
            numRunTimes = getValFromChild(getChildren().get(0));
        }
        catch (IllegalArgumentException e) {
            return;
        }
        for (int i = 0; i < numRunTimes; i++){
            getChildren().get(1).execute();
        }
    }
}
