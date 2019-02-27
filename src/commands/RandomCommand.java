package commands;

import backend.BackendManager;

import java.util.Random;

public class RandomCommand extends GeneralCommand {

    public RandomCommand(BackendManager bm) {
        super();
        myMaxChildren = 1;
        myType = "Random";
    }

    public void execute() {
        checkParameterCount();
        executeChildren();
        var childVals = getChildrenValues();
        double max = childVals.get(0);
        Random rand = new Random();
        myVal = rand.nextInt((int)max) - 0.1 * rand.nextInt(10);
    }
}


