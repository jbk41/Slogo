package commands;

import backend.BackendManager;

public class SineCommand extends GeneralCommand{

    public SineCommand(BackendManager bm){
        super(bm);
        myMaxChildren = 1;
        myType = "Sine";
    }

    public SineCommand(GeneralCommand c){
        super(c);
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double deg = myChildren.get(0).getVal()*Math.PI/180;
        myVal = Math.sin(deg);
    }
}
