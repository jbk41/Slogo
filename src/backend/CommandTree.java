package backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

import commands.*;
import parser.CommandFactory;
import parser.ParseCleaner;

public class CommandTree {
    private List<String> myArguments;
    private GeneralCommand head;
    private int start;
    private ParseCleaner cleaner;


    public CommandTree(String text, ParseCleaner clean){
        cleaner = clean;
        myArguments = new ArrayList<>(Arrays.asList(text.split("\\s+")));
        head = generateTree(myArguments.size()-1);
        linkParents(head);
        executeTree(head);
    }

    /**
     * prints the command tree post order
     */
    public void printTree(){
        printPostOrder(head);
    }

    public GeneralCommand getHead(){
        return head;
    }

    private GeneralCommand generateTree(int end){
        CommandFactory factory = new CommandFactory(myArguments.get(start), cleaner);
        GeneralCommand command = factory.getCommand();
        //GeneralCommand command = factory.getCommand(myArguments.get(start));

        if (start == end){
            return command;
        }
        //System.out.println(command.getType() + ":" +command.getMaxChildren());
        //System.out.println(start);
        for (int i = 0; i < command.getMaxChildren(); i ++){
            //System.out.println(i);
            start += 1;
            command.addChild(generateTree(end));
        }
        return command;
    }


    private void printPostOrder(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            printPostOrder(command);
        }
        // now deal with the node
        System.out.println(c.getType() + " with parent: " + c.printParent());
    }

    private void linkParents(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            command.setParent(c);
            linkParents(command);
        }
    }

    private void executeTree(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            executeTree(command);
        }
        c.execute();
    }

    // this is for testing only just to get a command
    private GeneralCommand getCommand(String s){
        if (s.equals("fd")){
            return new ForwardCommand();
        }
        else if (s.equals("+")){
            return new SumCommand();
        }
        else if (s.equals("*")){
            return new ProductCommand();
        }
        else if (s.equals("-")){
            return new DifferenceCommand();
        }
        else { // constant command
            return new ConstantCommand(Double.parseDouble(s));
        }
//        return new ForwardCommand();
    }
}
