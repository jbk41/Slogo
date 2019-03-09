package Executable;

public class ColorPaletteEntry extends Executable{

    private double index;
    private double r;
    private double g;
    private double b;

    public ColorPaletteEntry(double index, double r, double g, double b){
        this.index = index;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double getIndex(){
        return index;
    }

    public double getR(){
        return r;
    }

    public double getG(){
        return g;
    }

    public double getB(){
        return b;
    }

//    @Override
//    public String toString() {
//        return "change in palette";
//    }

}
