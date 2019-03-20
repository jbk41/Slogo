package commands;

import backend.BackendManager;

public class PenDownCommand extends StatementCommand{

    public PenDownCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        makeReady();
        setType("PenDown");
        setVal(1.0);
    }

    /**
     * Updates the TurtleState by setting the Pen Down
     */
    @Override
    public void update() {
        getBM().penDown();
    }

}
