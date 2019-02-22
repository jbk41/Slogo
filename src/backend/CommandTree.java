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
    private ParseCleaner lang;


    public CommandTree(String text){
        myArguments = new ArrayList<String>(Arrays.asList(text.split("\\s+")));
        head = generateTree(myArguments.size()-1);
    }

    /**
     * prints the command tree post order
     */
    public void printTree(){
        printPostOrder(head);
    }


    private GeneralCommand generateTree(int end){
//        var factory = new CommandFactory();
        GeneralCommand command = getCommand(myArguments.get(start));
        //GeneralCommand command = factory.getCommand(myArguments.get(start));

        if (start == end){
            return command;
        }
        System.out.println(command.getType() + ":" +command.getMaxChildren());
        System.out.println(start);
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
        System.out.print(c.getType() + " ");
    }


    // this is for testing only just to get a command
    private GeneralCommand getCommand(String s){
        if (s.equals("fd")){
            return new ForwardCommand();
        }
        else if (s.equals("+")){
            return new SumCommand();
        }
        else { // constant command
            return new ConstantCommand(Double.parseDouble(s));
        }
//        return new ForwardCommand();
    }
}
