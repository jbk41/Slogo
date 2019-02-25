package commands;
import backend.VariableManager;

public class VariableCommand extends GeneralCommand{

    private String myName;
    private VariableManager myVM;

    public VariableCommand(String name){
        super();
        //isFull = true;
        myType = "Variable";
        myMaxChildren = 0;
        myName = name;
        makeReady(); // variables should be ready upon initialization
    }

    public void setVariableManager(VariableManager vm){
        myVM = vm;
    }

    public String getName(){
        return myName;
    }

    public void execute(){
        return;
    }
}
