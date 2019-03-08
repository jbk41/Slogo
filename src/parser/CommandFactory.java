package parser;

import backend.BackendManager;
import backend.CommandManager;
import backend.Syntax;
import backend.VariableManager;
import commands.*;



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    final String VARIABLE_COMMAND_NAME = "Variable";
    final String CONSTANT_COMMAND_NAME = "Constant";
    private ParseCleaner myLanguages;
    public BackendManager myBM;

    public CommandFactory(ParseCleaner p, BackendManager bm) {
        myLanguages = p;
        myBM = bm;

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
            String commandName = list.get(0);

            if (commandName.equals(CONSTANT_COMMAND_NAME)) {
                System.out.println("Making constant command");
                return (GeneralCommand) Class.forName("commands." + commandName + "Command").getConstructor(BackendManager.class, double.class).newInstance(myBM, Double.parseDouble(list.get(1)));
            }
            else if (commandName.equals(VARIABLE_COMMAND_NAME)){
                System.out.println("Making variable command");
                return (GeneralCommand) Class.forName("commands." + commandName + "Command").getConstructor(BackendManager.class, String.class).newInstance(myBM, list.get(1));
            }
            else if (myLanguages.containsCommand(commandName)){
                System.out.println("standard com " + commandName);
                return (GeneralCommand) Class.forName("commands." + commandName + "Command").getConstructor(BackendManager.class).newInstance(myBM);
            }
            else if (myBM.containsCommand(commandName)){
                System.out.println("user com " + commandName);
                return new RunUserDefinedCommand(myBM, commandName);
            }
            else {
                System.out.println("undef com " + commandName);
                //System.out.println("Making undefined command");
                return new UndefinedCommand(myBM, commandName);
            }
        } catch (InstantiationException e) { System.out.println("The Command Could not be instantiated");
        } catch (InvocationTargetException e) { e.printStackTrace();
        } catch (NoSuchMethodException e) { System.out.println(e + ": " + list.get(0) + " Command does not exist");
        } catch (IllegalAccessException e) { e.printStackTrace();
        } catch (ClassNotFoundException e) { System.out.println(e + ": " + list.get(0) + " This Command does not exist"); }
        return null;
    }


    private List<String> parseText(String s) {
        List<String> cleanText = new ArrayList<>();
        String temp = myLanguages.getSymbol(s);
        cleanText.add(temp);
        if (temp.equals("Constant") || temp.equals("Variable")){
            cleanText.add(s);
        }
        return cleanText;
    }


}
