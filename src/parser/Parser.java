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
        addLanguages(LANGUAGES, Cleaner);
        myCleanText = parseText(text, Cleaner);
    }


    public ArrayList<String> getCleanText() { return myCleanText; }


    private ArrayList<String> parseText(String text, ParseCleaner lang) {
        var array = text.split(" ");
        var cleanText = new ArrayList<String>();
        for (String command : array) {
            if (numList().contains(command)){
                cleanText.add(command);
            }
            else{
                cleanText.add(lang.getSymbol(command));
            }
         }
        return cleanText;
    }


    private void addLanguages(String[] languages, ParseCleaner cleaner){
        for (String lang : languages) {
            cleaner.addPatterns("resources/languages/"+lang);
        }
    }

    private ArrayList<String> numList(){
        var nums = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            nums.add(Integer.toString(i));
        }
        return nums;
    }
}
