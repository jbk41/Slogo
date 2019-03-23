package commands;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;

/**
 * Forward command. Moves the active turtles forward.
 * @author Justin and Ale
 */
public class ForwardCommand extends MovementCommand {

    public ForwardCommand (BackendManager bm){
        super(bm);
        setType("Forward");
        setMaxChildren(1);
    }

    /**
     * Moves the active turtles forward by calling the backend manager API.
     */
    @Override
    public void update(){
        getBM().forward(getChildren().get(0).getVal());

    }
}
