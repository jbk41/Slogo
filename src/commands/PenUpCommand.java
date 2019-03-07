package commands;

import backend.BackendManager;

public class PenUpCommand extends StatementCommand {

    public PenUpCommand(BackendManager bm) {
        super(bm);
        makeReady();
        setMaxChildren(0);
        setType("PenUp");
        setVal(0);
    }

    @Override
    public void update() {
        getBM().penUp();
    }
}
