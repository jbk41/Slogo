package backend;

public class Syntax {

    private String myCommand;
    private int myLine;

    /**
     * Creates a Syntax object that holds string name of the syntax and the line it is on.
     * @param s
     * @param lineNumber
     */
    public Syntax(String s, int lineNumber){
        myCommand = s;
        myLine = lineNumber;
    }

    /**
     * Returns the line number of the Syntax.
     * @return
     */
    public int getLine(){
        return myLine;
    }

    /**
     * Returns the name of the Syntax
     * @return
     */
    public String getCommand(){
        return myCommand;
    }

    /**
     * Converts Syntax to a string
     * @return
     */
    public String toString(){
        return myCommand + " " + myLine;
    }
}
