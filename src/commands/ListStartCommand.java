package commands;

import backend.BackendManager;

public class ListStartCommand extends GeneralCommand {

    public ListStartCommand(BackendManager bm){
        super(bm);
        myType = "ListStart";
    }

    public ListStartCommand(GeneralCommand c){
        super(c);
    }

    public void execute(){
        for (GeneralCommand command: myChildren){
            command.execute();
        }
    }

    public int getNumActualChildren(){ // excludes the ending ] command
        return myChildren.size()-1;
    }

    public boolean doesContainEnd(){
        boolean containsEnd = false;
        for (GeneralCommand c : myChildren){
            if (c instanceof ListEndCommand){
                containsEnd = true;
            }
        }
        return containsEnd;
    }


}
