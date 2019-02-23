package commands;

public class ListCommand extends GeneralCommand {

    public ListCommand(){
        super();
    }

    @Override
    public GeneralCommand addChild(GeneralCommand c){
        myChildren.add(c);
        return c;
    }


}
