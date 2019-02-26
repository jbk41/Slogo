package commands;

public class NaturalLogCommand extends GeneralCommand{

    public NaturalLogCommand(){
        super();
        myMaxChildren = 1;
        myType = "NaturalLog";
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double log;
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            double val = c.getVal();
            log = Math.log(val);
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (NaturalLog accepts Constant nodes)");
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(log));
        makeReady();
    }

}
