package Executable;

public class ErrorMessage extends Executable {

    private String myError;
    private int myLineNumber;

    public ErrorMessage(String error, int lineNumber){
        myError = error;
        myLineNumber = lineNumber;
    }

    public String getError(){
        return "Line " + myLineNumber + ": " + myError;
    }

    @Override
    public String toString() { return "Error on Line " + myLineNumber + ": " + myError;}

}
