package commands;

import backend.BackendManager;

public class SetPaletteCommand extends GeneralCommand{

    public SetPaletteCommand(BackendManager bm){
        super(bm);
        setMaxChildren(4);
        setType("SetPaletteCommand");
    }

    public void execute(){
        checkParameterCount();
        executeChildren();
        double index = getChildren().get(0).getVal();
        double r = getChildren().get(1).getVal();
        double g = getChildren().get(2).getVal();
        double b = getChildren().get(3).getVal();
        checkValid(r);
        checkValid(g);
        checkValid(b);
        getBM().setColorPaletteEntry(index, r, g, b);
    }

    private void checkValid(double d){
        if ((d < 0 || d >= 256) || !(d == (int) d)){
            getBM().throwError("Color value must be an integer between 0 and 255", getLineNumber());
        }
    }
}
