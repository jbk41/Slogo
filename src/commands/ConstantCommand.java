package commands;
import backend.BackendManager;

/**
 * Command that holds a single value.
 * @author Justin and Ale
 */
public class ConstantCommand extends GeneralCommand{

    public ConstantCommand(BackendManager bm, double d){
        super(bm);
        setType("Constant");
        setMaxChildren(0);
        setVal(d);
        makeReady();
    }

    public void execute(){
        return;
    }


}
