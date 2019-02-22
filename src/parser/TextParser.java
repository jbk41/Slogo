package parser;

public class TextParser {
    private String[] myText; // all of the code line by line


    /**
     * makes a TextParser object, converts text into a list of discrete commands
     * @param text
     */
    public TextParser(String text){
        myText = text.split("\\r?\\n");
    }


    protected void interpret(){

    }

}
