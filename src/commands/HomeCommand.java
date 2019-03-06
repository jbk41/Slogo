package commands;

import backend.BackendManager;

public class HomeCommand extends StatementCommand{

    public HomeCommand (BackendManager bm){
        super(bm);
        myType = "Home";
        myMaxChildren = 0;
    }
    public HomeCommand(GeneralCommand c){
        super(c);
    }

    @Override
    public void update() {
        myBM.home();
    }
}
