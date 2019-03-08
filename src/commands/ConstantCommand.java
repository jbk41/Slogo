package commands;
import backend.BackendManager;

public class ConstantCommand extends GeneralCommand{

    public ConstantCommand(BackendManager bm, double d){
        super(bm);
        setType("Constant");
        setMaxChildren(0);
        setVal(d);
        makeReady();
    }

    public void execute(){
        System.out.println("running constant command");
        return;
    }


}
