package commands;

import backend.BackendManager;

/**
 * Creates a variable and sets its value.
 * @author Justin
 */
public class MakeVariableCommand extends GeneralCommand {

    final int VAR_INDEX = 0;
    final int VAL_INDEX = 1;

    public MakeVariableCommand(BackendManager bm){
        super(bm);
        setType("MakeVariable");
        setMaxChildren(2);
    }

    /**
     * Sets the value of a variable.
     */
    public void execute(){
        executeChildren();
        checkParameterCount();
        String varName = "";
        if (getChildren().get(VAR_INDEX) instanceof VariableCommand){
            VariableCommand vc = (VariableCommand) getChildren().get(0);
            varName = vc.getVarName();
        }
        else {
            getBM().throwError("Make command requires an actual variable", getLineNumber());
            return;
        }

        double val = getChildren().get(VAL_INDEX).getVal();
        getBM().setVariable(varName, val);

    }
}
