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
        for (int i = 0; i < myMaxChildren; i++){
            myChildren.get(i).execute();
        }
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
        myVal = sum;
        makeReady();
    }

//    public void prepare(){
//        try {
//            myVal = getValFromChild(myChildren.get(0)) + getValFromChild(myChildren.get(1));
//        }
//        catch (IllegalArgumentException e){
//            return;
//        }
//    }



}
