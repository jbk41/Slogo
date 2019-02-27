package parser;

import backend.CommandManager;
import backend.VariableManager;
import commands.*;
import java.util.List;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CommandFactory {

    private ParseCleaner myLanguages;
    public CommandManager CM;
    public VariableManager VM;
    //public GeneralCommand myCommand;
    private boolean isMovement = false;

    public CommandFactory(ParseCleaner p, CommandManager cm, VariableManager vm) {
        myLanguages = p;
        CM = cm;
        VM = vm;

    }


    /**
     * The string will be parsed (standardized through all languages and types), and then the Command Object for the
     * input String will be returned.
     *
     * @return Command object for input String
     */
    public GeneralCommand getCommand(String s) {
        List<String> cleanedText = parseText(s);
        checkIfMovement(cleanedText);
        return makeCommand(cleanedText);
    }


    private GeneralCommand makeCommand(List<String> list) {
        try {
            Class clazz = Class.forName("commands." + list.get(0) + "Command");
            try {
                if (list.size() == 1) return (GeneralCommand) clazz.getConstructor(CommandManager.class, VariableManager.class).newInstance(CM, VM);
                else return (GeneralCommand) clazz.getConstructor(double.class).newInstance(Double.parseDouble(list.get(1)));
            } catch (InstantiationException e) {
                System.err.println("Error: Could not instantiate Constant Object with the given value");
            } catch (NoSuchMethodException e) {
                System.out.println("Could not instantiate Command " + list.get(0));
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

    private void checkIfMovement(List<String> list){
        if (list.get(0).equals("Forward") || list.get(0).equals("Backward") || list.get(0).equals("Left") || list.get(0).equals("Right")) {
            isMovement = true;
        }
    }

    private ArrayList<String> parseText(String s) {
        ArrayList<String> cleanText = new ArrayList<>();
        String temp = myLanguages.getSymbol(s);
        cleanText.add(temp);
        if (temp.equals("Constant") || temp.equals("Variable")) {
            cleanText.add(s);
        }
        return cleanText;
    }
}
