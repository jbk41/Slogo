package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import commands.*;
import parser.CommandFactory;
import parser.ParseCleaner;

public class CommandTree {
    //private List<String> myArguments;
    private List<Syntax> myArguments;
    private GeneralCommand head;
    private int start;
    private int end;
    private CommandFactory myCommandFactory;
    private BackendManager myBM;


    public CommandTree(String text, ParseCleaner clean,  BackendManager bm){
        myArguments = split(text);
        myBM = bm;
        myCommandFactory = new CommandFactory(clean, myBM);
        head = new RootCommand(bm);
        end = myArguments.size() ;
        generateTree();
        linkParents(head);
        //linkParentsAndInitializeVariables(head);
        head.execute();

    }

    private List<Syntax> split(String text){
        SyntaxSplitter syntaxSplitter = new SyntaxSplitter();
        //System.out.println(syntaxSplitter.split(text).toString());
        return syntaxSplitter.split(text);
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

    private void linkParents(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            command.setParent(c);
            linkParents(command);
        }
    }

    // reads in string by word and generates syntax tree for a single "line" of commands
    private GeneralCommand generateOneSet(){
        Syntax syntax = myArguments.get(start);
        //System.out.println(syntax.getCommand());
        GeneralCommand command = myCommandFactory.getCommand(syntax.getCommand());
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
            if (command.getParent() instanceof UndefinedCommand){
                UndefinedCommand ud = (UndefinedCommand) command;
                String commandName = ud.getCommandName();
                if (command.getParent().getParent() instanceof MakeUserInstructionCommand){
                    myBM.setMaxVarForUserDefinedCommand(commandName, ((ListStartCommand) command).getNumActualChildren());
                }
            }
        }
        else { // handle every other command
            for (int i = 0; i < command.getMaxChildren(); i++) {
                start += 1;
                command.addChild(generateOneSet());
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
