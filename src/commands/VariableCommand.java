package commands;

public class VariableCommand extends GeneralCommand{

    private String myName;

    public VariableCommand(String name){
        super();
        //isFull = true;
        myType = "Variable";
        myMaxChildren = 1;
        myName = name;
    }

    public String getName(){
        return myName;
    }

    public void execute(){
        return;
    }
}
