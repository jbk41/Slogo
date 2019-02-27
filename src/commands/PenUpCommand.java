package commands;

public class PenUpCommand extends GeneralCommand {

    public PenUpCommand() {
        makeReady();
        myMaxChildren = 0;
        myType = "PenUp";
    }
}
