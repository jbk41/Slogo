package commands;

import backend.BackendManager;

public class PenDownCommand extends StatementCommand{

    public PenDownCommand(BackendManager bm) {
        super(bm);
        myMaxChildren = 0;
        makeReady();
        myType = "PenDown";
        myVal = 1.0;
    }

    @Override
    public void update() {
        myBM.penDown();
    }

}
