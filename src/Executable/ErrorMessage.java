package Executable;

public class ErrorMessage extends Executable {

    private String myError;

    public ErrorMessage(String error, int lineNumber){
        myError = "Line " + lineNumber + ": " + error;
    }

    public String getError(){
        return myError;
    }

//    @Override
//    public String toString() { return ("Error on Line " + myLineNumber + ": " + myError);}

}
