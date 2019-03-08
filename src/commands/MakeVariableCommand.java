package commands;

import backend.BackendManager;

public class MakeVariableCommand extends GeneralCommand {

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
            if (getChildren().get(0) instanceof VariableCommand){
                VariableCommand vc = (VariableCommand) getChildren().get(0);
                varName = vc.getVarName();
            }
            else {
                getBM().throwError("Make command requires an actual variable", getLineNumber());
                //TODO: not a variable error
                return;
            }

            double val = getChildren().get(1).getVal();
            getBM().setVariable(varName, val);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
