package commands;

import backend.BackendManager;

public class ShowTurtleCommand extends StatementCommand {

    public ShowTurtleCommand(BackendManager bm) {
        super(bm);
        makeReady();
        myMaxChildren = 0;
        myVal = 1;
        myType = "ShowTurtle";
    }

    public ShowTurtleCommand(GeneralCommand c){
        super(c);
    }

    @Override
    public void update() {
        myBM.showTurtle();
    }
}

