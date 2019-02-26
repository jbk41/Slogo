package commands;

public class MainTurtleCommand extends GeneralCommand{

    @Override
    public void execute() {
        checkParameterCount();
        myChildren.get(0).execute();

        GeneralCommand child = myChildren.get(0);
        try {
            myVal = child.getVal();
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
            return;
        }
    }

//    public void prepare(){
//        try {
//            myVal = getValFromChild(myChildren.get(0));
//        }
//        catch (IllegalAccessError e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public String toString(){
        return myType + ": " + Double.toString(myVal);
    }
}
