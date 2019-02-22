package parser;

import java.util.Scanner;


public class ParseTester {
    public static final String WHITESPACE = "\\s+";
    private String[] examples = {
            "",
            "# foo",
            "foo #",
            "#",
            "fd",
            "FD",
            "forwardd",
            "equalp",
            "equal?",
            "equal??",
            "+",
            "SuM",
            "-",
            "*",
            "/",
            "%",
            "~",
            "+not",
            "not+",
            "++",
            "+*+",
            "or",
            "FOR",
            "allOrNothing",
            "all_or_nothing",
            "allOr_nothing?",
            "allOr?nothing_",
            ":allornothing",
            "PI",
            "90",
            "9.09",
            "9.0.0",
            "[",
            "]",
            "(",
            ")"
    };


    // given some text, prints results of parsing it using the given language
    private void parseText (ParseCleaner lang, String[] text) {
        for (var s : text) {
            if (s.trim().length() > 0) {
                System.out.println(String.format("%s : %s", s, lang.getSymbol(s)));
            }
        }
        System.out.println();
    }


    public static void main (String[] args) {
        var m = new ParseTester();

        // set up the parser
        var lang = new ParseCleaner();
        // these are more specific, so add them first to ensure they are checked first
        lang.addPatterns("resources/languages/English");
        lang.addPatterns("resources/languages/Syntax");
        System.out.println(lang.getSymbol("fd"));

        // try against different inputs
        // note, this simple "algorithm" will not handle SLogo comments
        //m.parseText(lang, m.examples);
        String userInput = "fd 50 rt 90 BACK :distance Left :angle";
        m.parseText(lang, userInput.split(WHITESPACE));
        //String fileInput = m.readFileToString("/square.logo");
        //m.parseText(lang, fileInput.split(WHITESPACE));
    }
}
