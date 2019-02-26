package commands;

public class IfCommand extends GeneralCommand {

    public IfCommand(){
        super();
        myMaxChildren = 2;
        myType = "If";
    }

    public void execute(){
        GeneralCommand conditionCommand = myChildren.get(0);
        GeneralCommand executeCommand = myChildren.get(1);

        conditionCommand.execute();

        if (conditionCommand.getVal() != 0){
            executeCommand.execute();
        }
    }
}
