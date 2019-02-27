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
    private int end;
    private CommandFactory myCommandFactory;
    public BackendManager myBM;


    public CommandTree(String text, ParseCleaner clean,  BackendManager bm){
        myArguments = new ArrayList<>(Arrays.asList(text.split("\\s+")));
        myBM = bm;
        myCommandFactory = new CommandFactory(clean, myBM);
        head = new RootCommand();
        end = myArguments.size() ;
        generateTree();
        linkParentsAndInitializeVariables(head);
        head.execute();
    }

    /**
     * prints the command tree post order
     */
    public void printTree(){
        printPostOrder(head);
    }


    /**
     * returns head of the tree (should be a RootCommand object)
     * @return
     */
    public GeneralCommand getHead(){
        return head;
    }


    private void generateTree(){
        while (start != end){
            head.addChild(generateOneSet());
            start += 1;
        }
    }

    // reads in string by word and generates syntax tree for a single "line" of commands
    private GeneralCommand generateOneSet(){
        GeneralCommand command = myCommandFactory.getCommand(myArguments.get(start));
        //System.out.println(start);

        if (start == end){
            return command;
        }
        // handle lists
        if (command instanceof ListStartCommand){
            ListStartCommand lsc = (ListStartCommand) command;
            while (!lsc.doesContainEnd()){
                start += 1;
                lsc.addChild(generateOneSet());
            }
        }
        else { // handle every other command
            for (int i = 0; i < command.getMaxChildren(); i++) {
                start += 1;
                command.addChild(generateOneSet());
            }
        }
        return command;
    }


    /**
     * prints the tree with a post order traversal
     * @param c
     */
    public void printPostOrder(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            printPostOrder(command);
        }
        // now deal with the node
        System.out.println(c.toString() + " with parent: " + c.printParent());
    }

    // after the tree has been generated, use this to command to create a link from the child to the parent
    private void linkParentsAndInitializeVariables(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            command.setParent(c);
            if (c instanceof VariableCommand){
                VariableCommand temp = (VariableCommand) c;
                temp.setVariableManager(myBM.getVariableManager());
            }
            linkParentsAndInitializeVariables(command);
        }
    }

    // actually execute the command;
    private void executeTree(GeneralCommand c){
//        for (GeneralCommand command: c.getChildren()){
//            executeTree(command);
//        }
//        c.execute();
    }

}
