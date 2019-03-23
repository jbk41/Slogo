package commands;

import backend.BackendManager;

/**
 * Command that represents the start of a list.
 * @author Justin
 */
public class ListStartCommand extends GeneralCommand {

    public ListStartCommand(BackendManager bm){
        super(bm);
        setType("ListStart");
    }

    public void execute(){
        for (GeneralCommand command: getChildren()){
            command.execute();
        }
    }

    public int getNumActualChildren(){ // excludes the ending ] command
        return getChildren().size()-1;
    }

    /**
     * Checks to make sure if any of its children are a ListEndCommand. Signifies the end of a list.
     * @return
     */
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
