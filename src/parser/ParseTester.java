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

        String[] langs = {"English", "Syntax"};
        var lang = new ParseCleaner(langs);
        System.out.println(lang.getSymbol("fd"));

        m.parseText(lang, m.examples);
        String userInput = "fd 50 rt 90 BACK :distance Left :angle";
        m.parseText(lang, userInput.split(WHITESPACE));
    }
}
