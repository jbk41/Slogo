package commands;

import backend.BackendManager;

public class NotCommand extends GeneralCommand {


    public NotCommand(BackendManager bm){
        super(bm);
        myType = "Not";
        myMaxChildren = 1;
    }

    public void execute(){
        checkParameterCount();
        double returnVal = 0;
        GeneralCommand child = myChildren.get(0);
        if (child.getVal() == 0){
            returnVal = 1;
        }
        myVal = returnVal;
        makeReady();
//        if (child instanceof ConstantCommand){
//            ConstantCommand c = (ConstantCommand) child;
//            if (c.getVal() == 0){
//                returnVal = 1;
//            }
//        }
//        else {
//            throw new IllegalArgumentException("Illegal Argument Type (Product accepts constant arguments)");
//        }

        //int index = getIndexOfCurrentInParent();
        //myParent.getChildren().set(index, new ConstantCommand(returnVal));

    }
}
