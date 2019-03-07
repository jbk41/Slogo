package commands;

import backend.BackendManager;

public class HideTurtleCommand extends StatementCommand {

    public HideTurtleCommand(BackendManager bm) {
        super(bm);
        setMaxChildren(0);
        setType("HideTurtle");
        setVal(0);
        makeReady();
    }

    @Override
    public void update() {
        getBM().hideTurtle();
    }
}
