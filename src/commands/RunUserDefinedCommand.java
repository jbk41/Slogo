package commands;

import backend.BackendManager;

public class RunUserDefinedCommand extends GeneralCommand {

    private UserDefinedCommand userDefinedCommand;

    public RunUserDefinedCommand(BackendManager bm, String commandName){
        super(bm);
        userDefinedCommand = bm.getUserCommand(commandName);
        myMaxChildren = userDefinedCommand.getMaxArgs();

    }

    public void execute(){
        GeneralCommand vars = userDefinedCommand.getChildren().get(0);
        for (int i = 0; i < myMaxChildren; i++){
            GeneralCommand temp = vars.getChildren().get(i);
            VariableCommand vc;
            if (temp instanceof VariableCommand){
                vc = (VariableCommand) temp;
            }
            else {
                //TODO: throw and error. must be of type VariableCommand
            }
            
        }

    }

}
