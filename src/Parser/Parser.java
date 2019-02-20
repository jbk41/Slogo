package Parser;

public class Parser {

    private String myText;
    private ParseCleaner LIST_OF_COMMANDS;  // FIXME: Modules cleanup
    private String LANGUAGES[] = {"English"};


    Parser(String text){
        myText = text;
        LIST_OF_COMMANDS = new ParseCleaner();
        addLanguages(LANGUAGES);
//        String command = parseText(text);
    }

    private String parseText(String text){
        String command = LIST_OF_COMMANDS.getSymbol(text);
        return command;
    }


    private void dissectText(String text){
        String[] array = text.split(" ");
        String command = LIST_OF_COMMANDS.getSymbol(array[0]);

    }



    private void addLanguages(String[] languages){
        for (String lang : languages) {
            LIST_OF_COMMANDS.addPatterns(/*FIXME: ADD EXACT PATH*/ lang);
        }
    }
}
