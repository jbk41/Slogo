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
        GeneralCommand commands = userDefinedCommand.getChildren().get(1);
        if (myMaxChildren != userDefinedCommand.getMaxArgs()){
            //TODO: throw an error because userDefinedCommand needs to have
        }
        for (int i = 0; i < myMaxChildren; i++){
            GeneralCommand temp = vars.getChildren().get(i);
            VariableCommand vc;
            if (temp instanceof VariableCommand){
                vc = (VariableCommand) temp;
                myBM.setVariable(vc.getVarName(), myChildren.get(i).getVal());
            }
            else {
                //TODO: throw and error. must be of type VariableCommand
            }
        }
        commands.execute();
    }

}
