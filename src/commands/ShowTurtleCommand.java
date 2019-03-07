package commands;

import backend.BackendManager;

public class ShowTurtleCommand extends StatementCommand {

    public ShowTurtleCommand(BackendManager bm) {
        super(bm);
        makeReady();
        setMaxChildren(0);
        setVal(1);
        setType("ShowTurtle");
    }

    @Override
    public void update() {
        getBM().showTurtle();
    }
}

