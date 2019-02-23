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
 */
public class ParseCleaner {
    // "types" and the regular expression patterns that recognize those types
    // note, it is a list because order matters (some patterns may be more generic)
    private List<Entry<String, Pattern>> mySymbols;
    private String[] myLanguages;
    /**
     * Create an empty parser.
     */
    public ParseCleaner(String[] languages) {
        mySymbols = new ArrayList<>();
        myLanguages = languages;
        this.addPatterns(myLanguages);

    }


    /**
     * Adds the given resource files to this language's recognized types
     */
    public void addPatterns (String[] syntax) {
        for (String lang : syntax) {
            lang = "resources/languages/"+lang;
            try {
                var resources = ResourceBundle.getBundle(lang);
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
    private boolean match (String text, Pattern regex) {
        // THIS IS THE IMPORTANT LINE
        return regex.matcher(text).matches();
    }
}
