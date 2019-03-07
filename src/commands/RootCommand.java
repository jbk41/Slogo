package commands;
import backend.BackendManager;

import java.util.List;

public class RootCommand extends GeneralCommand {

    public RootCommand(BackendManager bm){
        super(bm);
        setType("Root");
    }

    public void execute(){
        for (GeneralCommand command: getChildren()){
            command.execute();
        }
    }
}
