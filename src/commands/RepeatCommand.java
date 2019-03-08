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
        System.out.println("executing repeat node");
        GeneralCommand numTimesCommand = getChildren().get(0);
        GeneralCommand commands = getChildren().get(1);
        if (!(commands instanceof ListStartCommand)){
            //TODO: throw an error, needs list start command type
        }
        numTimesCommand.execute();
        try {
            numRunTimes = getValFromChild(getChildren().get(0));
        }
        catch (IllegalArgumentException e) {
            return;
        }
        for (int i = 0; i < numRunTimes; i++){
            commands.execute();
        }
    }
}
