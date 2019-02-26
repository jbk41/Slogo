package commands;

public class PenDownCommand extends GeneralCommand{

    public PenDownCommand() {
        myMaxChildren = 0;
        makeReady();
        myType = "PenDown";
    }
}
