package backend;

public class Syntax {

    private String myCommand;
    private int myLine;

    public Syntax(String s, int lineNumber){
        myCommand = s;
        myLine = lineNumber;
    }

    public int getLine(){
        return myLine;
    }

    public String getCommand(){
        return myCommand;
    }

    public String toString(){
        return myCommand + " " + myLine;
    }
}
