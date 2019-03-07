package commands;

import backend.BackendManager;

public class SineCommand extends GeneralCommand{

    public SineCommand(BackendManager bm){
        super(bm);
        setMaxChildren(1);
        setType("Sine");
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double deg = getChildren().get(0).getVal()*Math.PI/180;
        setVal(Math.sin(deg));
    }
}
