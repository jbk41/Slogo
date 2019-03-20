package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import commands.*;
import parser.CommandFactory;
import parser.ParseCleaner;

public class CommandTree {
    //private List<String> myArguments;


    final int OFFSET = 1;
    final int UNDEFINED_INDEX = 0;
    final int SIZE_AFTER_UNDEFINED = 1;

    private List<Syntax> myArguments;
    private GeneralCommand head;
    private int start;
    private int end;
    private CommandFactory myCommandFactory;
    private BackendManager myBM;


    /**
     * Creates a syntax tree for the given text in the current language and updates the backend manager accordingly.
     * @param text
     * @param clean
     * @param bm
     */
    public CommandTree(String text, ParseCleaner clean,  BackendManager bm){
        myArguments = split(text);
        myBM = bm;
        myCommandFactory = new CommandFactory(clean, myBM);
        head = new RootCommand(bm);
        end = myArguments.size() ;
        generateTree();
        //linkParents(head);
        //linkParentsAndInitializeVariables(head);
        head.execute();

    }

    /**
     * Splits the text into Syntax objects (more well known as tokens).
     * @param text
     * @return
     */
    private List<Syntax> split(String text){
        SyntaxSplitter syntaxSplitter = new SyntaxSplitter();
        //System.out.println(syntaxSplitter.split(text).toString());
        return syntaxSplitter.split(text);
    }

    /**
     * Prints the command tree post order
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
            head.addChild(generateOneSet(head));
            start += 1;
        }
    }

    private void linkParents(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            command.setParent(c);
            linkParents(command);
        }
    }

    // reads in string by word and generates syntax tree for a single "line" of commands. One line is a contiguous
    // set of commands that can be defined on their own and do not require any pre or post knowledge of syntax.
    private GeneralCommand generateOneSet(GeneralCommand parent){
        Syntax syntax = myArguments.get(start);
        //System.out.println(syntax.getCommand());
        GeneralCommand command = myCommandFactory.getCommand(syntax.getCommand());
        command.setParent(parent);
        //System.out.println(start);

        if (start == end){
            return command;
        }
        // handle lists
        if (command instanceof ListStartCommand){
            ListStartCommand lsc = (ListStartCommand) command;
            while (!lsc.doesContainEnd()){
                start += 1;
                lsc.addChild(generateOneSet(command));
            }
            lsc.setMaxChildren(lsc.getChildren().size());
            if (command.getParent() instanceof MakeUserInstructionCommand && command.getParent().getChildren().size() == SIZE_AFTER_UNDEFINED){
                System.out.println("num of var: " + (command.getMaxChildren() - OFFSET));
                UndefinedCommand ud = (UndefinedCommand) command.getParent().getChildren().get(UNDEFINED_INDEX);
                String commandName = ud.getCommandName();
                myBM.setMaxVarForUserDefinedCommand(commandName, command.getMaxChildren() - OFFSET);
            }
        }
        else { // handle every other command
            for (int i = 0; i < command.getMaxChildren(); i++) {
                start += 1;
                command.addChild(generateOneSet(command));
            }
        }
        command.setLineNumber(syntax.getLine());
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
        //System.out.println(c.toString() + " with parent: " + c.printParent());
    }

}
