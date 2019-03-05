package commands;
import backend.BackendManager;

import java.util.List;

public class RootCommand extends GeneralCommand {

    public RootCommand(BackendManager bm){
        super(bm);
        myType = "Root";
    }

    public void execute(){
        for (GeneralCommand command: myChildren){
            command.execute();
        }
    }
}
