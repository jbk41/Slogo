package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SyntaxSplitter {

    final String NEW_LINE = "\\n+";
    final String SPACE = "\\s+";
    final String EMPTY = "";
    final char COMMENT = '#';

    public SyntaxSplitter(){
    }

    public List<Syntax> split(String text){
        List<Syntax> syntaxList = new ArrayList<>();
        List<String> textByLine = new ArrayList<>(Arrays.asList(text.split(NEW_LINE)));
        List<String> splitLine;
        String cleaned;
        Syntax syntax;
        for (int lineNum = 0; lineNum < textByLine.size(); lineNum++){
            cleaned = removeComment(textByLine.get(lineNum));
            splitLine = new ArrayList<>(Arrays.asList(cleaned.split(SPACE)));
            for (String s: splitLine){
                if (!s.equals(EMPTY)) {
                    syntax = new Syntax(s, lineNum);
                    syntaxList.add(syntax);
                }
            }
        }
        return syntaxList;


    }

    private String removeComment(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == COMMENT){
                return s.substring(0, i);
            }
        }
        return s;
    }

}
