package commands;

public class ArcTangentCommand extends GeneralCommand{

    public ArcTangentCommand(){
        super();
        myMaxChildren = 1;
        myType = "ArcTangent";
    }

    public void execute(){
        checkParameterCount();
        GeneralCommand child = myChildren.get(0);
        double val;
        double atan;
        try {
            val = getValFromChild(child);
        }

        catch (IllegalArgumentException e){
            System.out.println(e);
            return;
        }
        double deg = val*Math.PI/180;
        atan = Math.atan(deg);



        int index = getIndexOfCurrentInParent();
        myParent.getChildren().set(index, new ConstantCommand(atan));
        makeReady();
    }

}
