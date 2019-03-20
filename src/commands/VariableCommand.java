package commands;

import backend.BackendManager;


public class VariableCommand extends GeneralCommand{

    private String myName;

    public VariableCommand(BackendManager bm, String name){
        super(bm);
       setType("Variable");
        setMaxChildren(0);
        myName = name;
    }

    /**
     * Executes the command: Adds the variable to the Variable Manager Map with its respective value
     */
    public void execute() {
        if(getBM().hasVariable(myName)) {
            setVal(getBM().getVariable(myName));
        }
        else {
            setVal(0);
        }
    }

    /**
     * Returns the name of the variable
     * @return
     */
    public String getVarName() {
        return myName; }
}
