package backend;

public class TestClass {

    public static void main (String[] args){
        CommandTree t = new CommandTree("fd + + + 1 2 3 4");
        System.out.println("hi");
        t.printTree();
    }
}
