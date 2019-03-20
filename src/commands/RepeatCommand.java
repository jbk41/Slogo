package commands;

import backend.BackendManager;

public class RepeatCommand extends GeneralCommand {

    public RepeatCommand(BackendManager bm){
        super(bm);
        setType("Repeat");
        setMaxChildren(2);
    }

    /**
     * Executes command. Executes the commands of the second input (list) as many times as the
     * first input.
     */
    public void execute(){
        double numRunTimes;
        System.out.println("executing repeat node");
        GeneralCommand numTimesCommand = getChildren().get(0);
        GeneralCommand commands = getChildren().get(1);
        if (!(commands instanceof ListStartCommand)){
            getBM().throwError("Repeat requires list parameter", getLineNumber());
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
