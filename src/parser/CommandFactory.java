package parser;

import backend.BackendManager;
import backend.CommandManager;
import backend.VariableManager;
import commands.*;



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    private ParseCleaner myLanguages;
    public BackendManager BM;

    public CommandFactory(ParseCleaner p, BackendManager bm) {
        myLanguages = p;
        BM = bm;

    }


    /**
     * The string will be parsed (standardized through all languages and types), and then the Command Object for the
     * input String will be returned.
     *
     * @return Command object for input String
     */
    public GeneralCommand getCommand(String s) {
        List<String> cleanedText = parseText(s);
        return makeCommand(cleanedText);
    }


    private GeneralCommand makeCommand(List<String> list) {
        try {
            Class clazz = Class.forName("commands." + list.get(0) + "Command");
            if (list.size() == 1) return (GeneralCommand) clazz.getConstructor(BackendManager.class).newInstance(BM);
            else if (list.get(0).equals("Constant")) return (GeneralCommand) clazz.getConstructor(double.class).newInstance(Double.parseDouble(list.get(1)));
            else  return (GeneralCommand) clazz.getConstructor(BackendManager.class, String.class).newInstance(BM, list.get(1));
        } catch (InstantiationException e) { System.out.println("The Command Could not be instantiated");
        } catch (InvocationTargetException e) { e.printStackTrace();
        } catch (NoSuchMethodException e) { System.out.println(e + ": This Command does not exist");
        } catch (IllegalAccessException e) { e.printStackTrace();
        } catch (ClassNotFoundException e) { System.out.println(e + ": This Command does not exist"); }
        return null;
    }


    private ArrayList<String> parseText(String s) {
        ArrayList<String> cleanText = new ArrayList<>();
        String temp = myLanguages.getSymbol(s);
        cleanText.add(temp);
        if (temp.equals("Constant") || temp.equals("Variable")){
            cleanText.add(s);
        }
        return cleanText;
    }


}
