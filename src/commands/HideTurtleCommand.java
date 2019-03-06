package commands;

import backend.BackendManager;

public class HideTurtleCommand extends StatementCommand {

    public HideTurtleCommand(BackendManager bm) {
        super(bm);
        myMaxChildren = 0;
        myType = "HideTurtle";
        myVal = 0;
        makeReady();
    }

    public HideTurtleCommand(GeneralCommand c){
        super(c);
    }

    @Override
    public void update() {
        myBM.hideTurtle();
    }
}
