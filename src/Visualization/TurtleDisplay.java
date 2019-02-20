package Visualization;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TurtleDisplay extends Pane{
    private static final String TURTLE_IMAGE = "turtle.gif";
    private int width;
    private int height;
    private int padding;
    private Paint BACKGROUND = Color.WHITE;
    public TurtleDisplay(int width, int height, int padding){
        this.width = width;
        this.height = height;
        this.padding = padding;
        setSizeOfRoot();
        setBackground(new Background(new BackgroundFill(BACKGROUND, CornerRadii.EMPTY, Insets.EMPTY)));
        addTurtleToRoot();
    }
    private void setSizeOfRoot(){
        double fixedWidth = getFixedWidth(width, padding);
        double fixedHeight = getFixedHeight(height, padding);
        setPrefWidth(fixedWidth);
        setPrefHeight(fixedHeight);
    }
    private double getFixedWidth(int width, int padding){
        double doubleWidth = (double)width / 2;
        int totalPadding = padding * 2;
        return doubleWidth - totalPadding;
    }
    private double getFixedHeight(int height, int padding){
        double doubleHeight= (double)height  * 0.90;
        int totalPadding = padding * 2;
        return doubleHeight- totalPadding;
    }
    private void addTurtleToRoot(){
        Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
        ImageView turtleImageView = new ImageView(turtleImage);
        getChildren().add(turtleImageView);
        setDefaultTurtleLocation(turtleImageView);
    }
    private void setDefaultTurtleLocation(ImageView turtleImageView){
        turtleImageView.setX(getPrefWidth() / 2);
        turtleImageView.setY(getPrefHeight() / 2);
    }
}
