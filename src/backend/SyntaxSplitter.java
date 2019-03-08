package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SyntaxSplitter {

    public SyntaxSplitter(){
    }

    public List<Syntax> split(String text){
        List<Syntax> syntaxList = new ArrayList<>();
        List<String> textByLine = new ArrayList<>(Arrays.asList(text.split("\\n+")));
        List<String> splitLine;
        String cleaned;
        Syntax syntax;
        for (int lineNum = 0; lineNum < textByLine.size(); lineNum++){
            cleaned = removeComment(textByLine.get(lineNum));
            splitLine = new ArrayList<>(Arrays.asList(cleaned.split("\\s+")));
            for (String s: splitLine){
                if (!s.equals("")) {
                    syntax = new Syntax(s, lineNum);
                    syntaxList.add(syntax);
                }
            }
        }
        return syntaxList;


    }

    private String removeComment(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '#'){
                return s.substring(0, i);
            }
        }
        return s;
    }

}
