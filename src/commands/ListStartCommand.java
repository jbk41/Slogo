package commands;

public class ListStartCommand extends GeneralCommand {

    public ListStartCommand(){
        super();
        myType = "ListStart";
    }

    public void execute(){
        for (GeneralCommand command: myChildren){
            command.execute();
        }
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
