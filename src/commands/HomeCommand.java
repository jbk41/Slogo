package commands;

import backend.BackendManager;

public class HomeCommand extends StatementCommand{

    public HomeCommand (BackendManager bm){
        super(bm);
        setType("Home");
        setMaxChildren(0);
    }

    @Override
    public void update() {
        getBM().home();
    }
}
