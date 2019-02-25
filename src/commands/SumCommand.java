package commands;

public class SumCommand extends GeneralCommand {

    public SumCommand(){
        super();
        myType = "Sum";
        myMaxChildren = 2;
    }

    @Override
    public void execute() throws IllegalArgumentException{
        checkParameterCount();
        double sum = 0;
        for (GeneralCommand child: myChildren){
            try {
                sum += getValFromChild(child);
            }
            catch (IllegalArgumentException e){
                System.out.println(e);
                return;
            }
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(sum));
        makeReady();
    }



}
