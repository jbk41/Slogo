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
    private VariableManager myVM;


    public CommandTree(String text, ParseCleaner clean, VariableManager vm){
        myArguments = new ArrayList<>(Arrays.asList(text.split("\\s+")));
        myCommandFactory = new CommandFactory(clean);
        head = generateTree(myArguments.size()-1);
        myVM = vm;

        linkParentsAndInitializeVariables(head);
        //executeTree(head);
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
        // handle if myArguments.get(start) is [ or ]
//        if (myArguments.get(start).equals("]")){
//            return ;
//        }
        GeneralCommand command = myCommandFactory.getCommand(myArguments.get(start));

        if (start == end){
            return command;
        }

        for (int i = 0; i < command.getMaxChildren(); i ++){
            start += 1;
            command.addChild(generateTree(end));
        }
        return command;
    }




    public void printPostOrder(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            printPostOrder(command);
        }
        // now deal with the node
        System.out.println(c.toString() + " with parent: " + c.printParent());
    }

    private void linkParentsAndInitializeVariables(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            command.setParent(c);
            if (c instanceof VariableCommand){
                VariableCommand temp = (VariableCommand) c;
                temp.setVariableManager(myVM);
            }
            linkParentsAndInitializeVariables(command);
        }
    }

    private void executeTree(GeneralCommand c){
        for (GeneralCommand command: c.getChildren()){
            executeTree(command);
        }
        c.execute();
    }
}
