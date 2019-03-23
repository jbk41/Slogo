package Executable;

/**
 * Throws and error message in the console.
 * @author Justin
 */
public class ErrorMessage extends Executable {

    private String myError;

    /**
     * Creates a new error executable for the front end.
     * @param error
     * @param lineNumber
     */
    public ErrorMessage(String error, int lineNumber){
        myError = "Line " + lineNumber + ": " + error;
    }

    /**
     * Returns the error message as a string.
     * @return
     */
    public String getError(){
        return myError;
    }

    @Override
    public String toString() { return ("Error on Line " + ": " + myError);}

}
