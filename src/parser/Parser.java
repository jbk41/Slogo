package parser;

import java.util.ArrayList;

public class Parser {

    private String myText;
    private ParseCleaner Cleaner;
    private String LANGUAGES[];
    private ArrayList<String> myCleanText;
    private ArrayList<String> nums;


    public Parser(String text, String[] languages){
        nums = numList(); //FIXME: We shouldn't do this, but OK for now
        myText = text;
        LANGUAGES = languages;
        Cleaner = new ParseCleaner();
        //addLanguages(LANGUAGES, Cleaner);
        //myCleanText = parseText(text, Cleaner);
    }


    public ArrayList<String> getCleanText() { return myCleanText; }




    private ArrayList<String> numList(){
        var nums = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            nums.add(Integer.toString(i));
        }
        return nums;
    }
}
