package commands;
import backend.BackendManager;

import java.util.List;

public class RootCommand extends GeneralCommand {

    public RootCommand(BackendManager bm){
        super(bm);
        setType("Root");
    }

    /**
     * Executes children. Root Commands are special because they are the first command in the commandTree.
     */
    public void execute(){
        for (GeneralCommand command: getChildren()){
            command.execute();
        }
    }
}
