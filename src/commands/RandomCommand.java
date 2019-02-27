package commands;

import java.util.Random;

public class RandomCommand extends GeneralCommand {

    public RandomCommand() {
        super();
        myMaxChildren = 1;
        myType = "Random";
    }

    public void execute() {
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double n;
        if (child instanceof ConstantCommand){
            ConstantCommand c = (ConstantCommand) child;
            double max = c.getVal();
            Random rand = new Random();
            n = rand.nextInt((int)max) - 0.1 * rand.nextInt(10);
        }
        else {
            throw new IllegalArgumentException("Illegal Argument Type (Random accepts Constant nodes)");
        }
        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(n));
        makeReady();
    }
}


