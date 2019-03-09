package commands;

import backend.BackendManager;

import java.util.Random;

public class RandomCommand extends GeneralCommand {

    final int VAL_INDEX = 0;
    final double OFFSET = .1;
    final int LIMIT = 10;

    public RandomCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(1);
        setType("Random");
    }

    public void execute() {
        checkParameterCount();
        executeChildren();
        double max = getChildren().get(VAL_INDEX).getVal();
        Random rand = new Random();
        setVal(rand.nextInt((int)max) - OFFSET * rand.nextInt(LIMIT));
    }
}


