package Commands;

public class Sum extends Command{
    public int ARG1, ARG2;

    Sum(int arg1, int arg2){
        super(arg1, arg2);
    }

    public int update(){
        int num = ARG1 + ARG2;
        return num;
    }


}
