package commands;

import backend.BackendManager;

public class RunUserDefinedCommand extends GeneralCommand {

    private UserDefinedCommand userDefinedCommand;

    public RunUserDefinedCommand(BackendManager bm, String commandName){
        super(bm);
        userDefinedCommand = bm.getUserCommand(commandName);
        setMaxChildren(userDefinedCommand.getMaxArgs());
    }

    public void execute(){
        GeneralCommand vars = userDefinedCommand.getChildren().get(0);
        GeneralCommand commands = userDefinedCommand.getChildren().get(1);
        if (getMaxChildren() != userDefinedCommand.getMaxArgs()){
            //TODO: throw an error because userDefinedCommand needs to have
        }
        for (int i = 0; i < getMaxChildren(); i++){
            GeneralCommand temp = vars.getChildren().get(i);
            VariableCommand vc;
            if (temp instanceof VariableCommand){
                vc = (VariableCommand) temp;
                getBM().setVariable(vc.getVarName(), getChildren().get(i).getVal());
            }
            else {
                //TODO: throw and error. must be of type VariableCommand
            }
        }
        commands.execute();
    }

}
