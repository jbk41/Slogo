package Visualization;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class TurtleDisplay extends Pane {
    private double width;
    private double height;
    private int padding;
    private Paint BACKGROUND = Color.WHITE;
    private Paint PEN_COLOR;
    private int PEN_SIZE = 4;
    private Canvas canvas;

    public TurtleDisplay(double width, double height, int padding){
        this.width = width;
        this.height = height;
        this.padding = padding;
        setSizeOfRoot();
        canvas = new Canvas(getFixedWidth(width,padding), getFixedHeight(height,padding));
        getChildren().add(canvas);
        setBackground(new Background(new BackgroundFill(BACKGROUND, CornerRadii.EMPTY, Insets.EMPTY)));
        setMaxWidth(getFixedWidth(width, padding));
        setPrefHeight(getFixedHeight(height, padding));
    }
    public Canvas createNewCanvas(){
        getChildren().remove(canvas);
        canvas = new Canvas(getFixedWidth(width,padding), getFixedHeight(height,padding));
        getChildren().add(canvas);
        return canvas;

    }

    public void setPEN_COLOR(Paint color) {
        PEN_COLOR = color;
    }

    public void setPEN_SIZE(int size) {
        PEN_SIZE = size;
    }

    public Paint getPEN_COLOR() {
        return PEN_COLOR;
    }

    public int getPEN_SIZE() {
        return PEN_SIZE;
    }
    private void setSizeOfRoot(){
        double fixedWidth = getFixedWidth(width, padding);
        double fixedHeight = getFixedHeight(height, padding);
        setPrefSize(fixedWidth,fixedHeight);
    }
    private double getFixedWidth(double width, int padding){
        double doubleWidth = width / 2;
        int totalPadding = padding * 2;
        return doubleWidth - totalPadding;
    }
    private double getFixedHeight(double height, int padding){
        double doubleHeight= height  * 0.90;
        int totalPadding = padding * 2;
        return doubleHeight- totalPadding;
    }

    public Canvas getCanvas(){return canvas;}
}
