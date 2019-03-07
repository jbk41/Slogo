package commands;

import backend.BackendManager;

import java.util.Random;

public class RandomCommand extends GeneralCommand {

    public RandomCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(1);
        setType("Random");
    }

    public void execute() {
        checkParameterCount();
        executeChildren();
        double max = getChildren().get(0).getVal();
        Random rand = new Random();
        setVal(rand.nextInt((int)max) - 0.1 * rand.nextInt(10));
    }
}


