package commands;

import backend.BackendManager;

public class MakeVariableCommand extends GeneralCommand {

    final int VAR_INDEX = 0;
    final int VAL_INDEX = 1;

    public MakeVariableCommand(BackendManager bm){
        super(bm);
        setType("MakeVariable");
        setMaxChildren(2);
    }

    public void execute(){
        executeChildren();
        checkParameterCount();
        try {
            String varName = "";
            if (getChildren().get(VAR_INDEX) instanceof VariableCommand){
                VariableCommand vc = (VariableCommand) getChildren().get(0);
                varName = vc.getVarName();
            }
            else {
                getBM().throwError("Make command requires an actual variable", getLineNumber());
                //TODO: not a variable error
                return;
            }

            double val = getChildren().get(VAL_INDEX).getVal();
            getBM().setVariable(varName, val);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
