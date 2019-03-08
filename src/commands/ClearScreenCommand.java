package commands;

import backend.BackendManager;

public class ClearScreenCommand extends StatementCommand {

    public ClearScreenCommand(BackendManager bm){
        super(bm);
        setType("ClearScreen");
        setMaxChildren(0);
    }


    @Override
    public void update() {
        checkParameterCount();
        getBM().clearScreen();
    }
}
