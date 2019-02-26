package commands;

public class ListStartCommand extends GeneralCommand {

    public ListStartCommand(){
        super();
        myType = "ListStart";
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
