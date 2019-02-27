package backend;

import commands.BackwardCommand;

public class BackendManager {

    public CommandManager myCM;
    public VariableManager myVM;

    public BackendManager(CommandManager cm, VariableManager vm){
        myCM = cm;
        myVM = vm;
    }

    public CommandManager getCommandManager() { return myCM; }

    public VariableManager getVariableManager() { return myVM; }
}
