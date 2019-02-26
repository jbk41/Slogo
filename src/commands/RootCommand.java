package commands;

import java.util.List;

public class RootCommand extends GeneralCommand {

    public RootCommand(){
        myType = "Root";
    }

    public void execute(){
        for (GeneralCommand command: myChildren){
            command.execute();
        }
    }
}
