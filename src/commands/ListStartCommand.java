package commands;

import backend.BackendManager;

public class ListStartCommand extends GeneralCommand {

    public ListStartCommand(BackendManager bm){
        super(bm);
        setType("ListStart");
    }

    public void execute(){
        System.out.println("executing list");
        for (GeneralCommand command: getChildren()){
            command.execute();
        }
    }

    public int getNumActualChildren(){ // excludes the ending ] command
        return getChildren().size()-1;
    }

    public boolean doesContainEnd(){
        boolean containsEnd = false;
        for (GeneralCommand c : getChildren()){
            if (c instanceof ListEndCommand){
                containsEnd = true;
            }
        }
        return containsEnd;
    }


}
