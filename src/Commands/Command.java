package Commands;

abstract public class Command {
    public Class myType;
    public int ARG1;
    public int ARG2;

    Command(int arg1, int arg2) {
        myType = getClass();
        ARG1 = arg1;
        ARG2 = arg2;
    }

    Command(int arg) {
        myType = getClass();
        ARG1 = arg;
    }

    Command() {
        myType = getClass();
        ARG1 = 0;
        ARG2 = 0;
    }

    public Class getType() { return myType; }

    public int getArg1() { return ARG1; }

    public int getArg2() { return ARG2; }

    public abstract int update();

}
