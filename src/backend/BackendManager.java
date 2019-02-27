package backend;

import TurtleState.TurtleManager;
import commands.BackwardCommand;

public class BackendManager {

    public CommandManager myCM;
    public VariableManager myVM;
    public TurtleManager myTM;

    public BackendManager(CommandManager cm, VariableManager vm){
        myCM = cm;
        myVM = vm;
    }

    public CommandManager getCommandManager() { return myCM; }

    public VariableManager getVariableManager() { return myVM; }

}
