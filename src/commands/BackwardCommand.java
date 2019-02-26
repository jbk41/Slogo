package commands;

public class BackwardCommand extends GeneralCommand {

    public BackwardCommand() {
        super();
        myMaxChildren = 1;
        myType = "Backward";
    }

    public void execute(){
        checkParameterCount();

        GeneralCommand child = myChildren.get(0);

        try {
            this.myVal = getValFromChild(child);
            myChildren.clear();
        }

        catch (IllegalArgumentException e){
            System.out.println(e);
            return;
        }

        makeReady();
    }
}
