package parser;

import commands.ForwardCommand;
import commands.GeneralCommand;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CommandFactory {

    private ParseCleaner Cleaner;
    private ArrayList<String> myCleanText;
    public GeneralCommand myCommand;

    public CommandFactory(String s, ParseCleaner p) {
        Cleaner = p;
        myCleanText = parseText(s, Cleaner);
        myCommand = makeCommand(myCleanText);

    }


    /**
     * The string will be parsed (standardized through all languages and types), and then the Command Object for the
     * input String will be returned.
     *
     * @return Command object for input String
     */
    public GeneralCommand getCommand() {
        return myCommand;
    }


    private GeneralCommand makeCommand(ArrayList<String> list) {
        try {
            Class clazz = Class.forName("commands." + list.get(0) + "Command");
            try {
                if (list.size() == 1) {
                    Object command = clazz.getConstructor().newInstance();
                    return (GeneralCommand) command;
                } else {
                    Object command = clazz.getConstructor(double.class).newInstance(Double.parseDouble(list.get(1)));
                    return (GeneralCommand) command;
                }
            } catch (InstantiationException e) {
                System.err.println("Error: Could not instantiate Constant Object with the given value");
            } catch (NoSuchMethodException e) {
                System.out.println("Could not instantiate Command Object " + list.get(0));
            } catch (IllegalAccessException e) {
                System.err.println("Error: " + e);
            } catch (InvocationTargetException e) {
                System.out.println("Error: " + e);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("The command " + list.get(0) + " does not exist");
        }
        return null;
    }


    private ArrayList<String> parseText(String s, ParseCleaner lang) {
        ArrayList<String> cleanText = new ArrayList<>();
        String temp = lang.getSymbol(s);
        cleanText.add(temp);
        if (temp.equals("Constant") || temp.equals("Variable")) {
            cleanText.add(s);
        }
        return cleanText;
    }
}


//    private GeneralCommand makeVarCommand(ArrayList<String> list) {
//
//}