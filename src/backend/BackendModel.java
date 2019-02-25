package backend;
import parser.ParseCleaner;
import commands.GeneralCommand;

public class BackendModel implements BackendAPI {


    private VariableManager myVM;
    private CommandTree myCT;
    private ParseCleaner myPC;

    public BackendModel(){
        myVM = new VariableManager();
    }

    public void setLanguage(String language){
        myPC = new ParseCleaner(language);
    }

    public void interpret(String text){
        myCT = new CommandTree(text, myPC, myVM);
    }

    public void printTree(){
        myCT.printTree();
    }



}
