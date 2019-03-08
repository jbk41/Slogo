package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

public class ForwardCommand extends MovementCommand {

    public ForwardCommand (BackendManager bm){
        super(bm);
        setType("Forward");
        setMaxChildren(1);
    }

    @Override
    public void update(){
        System.out.println("about to add turtle forward command to list");
        getBM().forward(getChildren().get(0).getVal());
        System.out.println("added turtle forward command to list");

    }
}
