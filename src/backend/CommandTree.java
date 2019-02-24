package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import commands.*;
import parser.CommandFactory;
import parser.ParseCleaner;

public class CommandTree {
    private List<String> myArguments;
    private GeneralCommand head;
    private int start;
    private CommandFactory myCommandFactory;


    public CommandTree(String text, ParseCleaner clean){
        myArguments = new ArrayList<>(Arrays.asList(text.split("\\s+")));
        myCommandFactory = new CommandFactory(clean);
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

        GeneralCommand command = myCommandFactory.getCommand(myArguments.get(start));

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
}
