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


    public void execute() {
        if(getBM().hasVariable(myName)) {
            setVal(getBM().getVariable(myName));
        }
        else {
            setVal(0);
        }
    }

    public String getVarName() {
        return myName; }
}
