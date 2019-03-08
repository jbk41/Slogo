package commands;

import backend.BackendManager;

public class RunUserDefinedCommand extends GeneralCommand {

    private UserDefinedCommand userDefinedCommand;

    public RunUserDefinedCommand(BackendManager bm, String commandName){
        super(bm);
        if (!getBM().containsCommand(commandName)){
            getBM().throwError("Unrecognizable command", getLineNumber());
        }
        userDefinedCommand = bm.getUserCommand(commandName);
        setMaxChildren(userDefinedCommand.getMaxArgs());
    }

    public void execute(){
        GeneralCommand vars = userDefinedCommand.getChildren().get(0);
        GeneralCommand commands = userDefinedCommand.getChildren().get(1);
        if (getMaxChildren() != userDefinedCommand.getMaxArgs()){
            getBM().throwError("Wrong number of requirements for user defined command", getLineNumber());
            return;
        }
        for (int i = 0; i < getMaxChildren(); i++){
            GeneralCommand temp = vars.getChildren().get(i);
            VariableCommand vc;
            if (temp instanceof VariableCommand){
                vc = (VariableCommand) temp;
                getBM().setVariable(vc.getVarName(), getChildren().get(i).getVal());
            }
            else {
                getBM().throwError("Requires variable command", getLineNumber());
                return;
            }
        }
        commands.execute();
    }

}
