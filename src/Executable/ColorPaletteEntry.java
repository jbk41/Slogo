package Executable;

/**
 * Adds a new color palette entry.
 * @author Justin
 */
public class ColorPaletteEntry extends Executable{

    private double index;
    private double r;
    private double g;
    private double b;

    /**
     * Creates a color palette entry that holds its index, and RGB values.
     * @param index
     * @param r
     * @param g
     * @param b
     */
    public ColorPaletteEntry(double index, double r, double g, double b){
        this.index = index;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Gets the index of the color palette.
     * @return
     */
    public double getIndex(){
        return index;
    }

    /**
     * Gets the R value of the color palette entry.
     * @return
     */
    public double getR(){
        return r;
    }

    /**
     * Gets the G value of the color palette entry.
     * @return
     */
    public double getG(){
        return g;
    }

    /**
     * Gets the B value of the color palette entry.
     * @return
     */
    public double getB(){
        return b;
    }

}
