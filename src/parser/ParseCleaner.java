package parser;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * Simple parser based on regular expressions that matches program strings to
 * kinds of language features.
 *
 * @author Robert C. Duvall
 * @modified_by Alejandro Meza
 */
public class ParseCleaner {

    final String SYNTAX_KEY = "Syntax";
    private List<Entry<String, Pattern>> mySymbols;
    private String myLanguage;


    public ParseCleaner(String language) {
        mySymbols = new ArrayList<>();
        myLanguage = language;
        this.addPatterns(myLanguage);
    }


    /**
     * Adds the given resource file to this language's recognized types
     */
    public void addPatterns (String language) {
        addLang(language);
        addLang(SYNTAX_KEY);
    }

    /**
     * checks if commandName is a valid command
     * @param commandName
     * @return
     */
    public boolean containsCommand(String commandName){
        String symbol = getSymbol(commandName);
        for (Entry<String, Pattern> entry: mySymbols){
            if (entry.getKey().equals(symbol)){
                return true;
            }
        }
        return false;
    }


    private void addLang(String lang) {
        try {
            String language = "resources/languages/" + lang;
            var resources = ResourceBundle.getBundle(language);
            for (var key : Collections.list(resources.getKeys())) {
                var regex = resources.getString(key);
                mySymbols.add(new SimpleEntry<>(key,
                        // THIS IS THE IMPORTANT LINE
                        Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
            }
        } catch (MissingResourceException e) {
            System.err.println(e);
            }
    }


    /**
     * Returns language's type associated with the given text if one exists
     */
    public String getSymbol (String text) {
        final var ERROR = "NO MATCH";
        for (var e : mySymbols) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        // FIXME: perhaps throw an exception instead
        return ERROR;
    }


    /**
     * Returns true if the given text matches the given regular expression pattern
     */
    private boolean match(String text, Pattern regex) {
        // THIS IS THE IMPORTANT LINE
        return regex.matcher(text).matches();
    }
}
