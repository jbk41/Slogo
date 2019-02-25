package commands;

public class ListCommand extends GeneralCommand {

    public ListCommand(){
        super();
        myType = "List";
    }

    @Override
    public GeneralCommand addChild(GeneralCommand c){
        myChildren.add(c);
        return c;
    }


}
