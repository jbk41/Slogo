package commands;

import backend.BackendManager;

public class SetPaletteCommand extends GeneralCommand{

    final int INDEX_INDEX = 0;
    final int R_INDEX = 1;
    final int G_INDEX = 2;
    final int B_INDEX = 3;
    final int MAX_RGB = 256;
    final int MIN_RGB = 0;

    public SetPaletteCommand(BackendManager bm){
        super(bm);
        setMaxChildren(4);
        setType("SetPaletteCommand");
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double index = getChildren().get(INDEX_INDEX).getVal();
        double r = getChildren().get(R_INDEX).getVal();
        double g = getChildren().get(G_INDEX).getVal();
        double b = getChildren().get(B_INDEX).getVal();
        checkValid(r);
        checkValid(g);
        checkValid(b);
        getBM().setColorPaletteEntry(index, r, g, b);
    }

    private void checkValid(double d){
        if ((d < MIN_RGB || d >= MAX_RGB) || !(d == (int) d)){
            getBM().throwError("Color value must be an integer between 0 and 255", getLineNumber());
        }
    }
}
