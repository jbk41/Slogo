package Visualization;

import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;

public class TurtleDisplay extends Pane{
    private static final String TURTLE_IMAGE = "turtle.gif";
    private int width;
    private int height;
    private int padding;
    private ImageView turtleImageView;
    private Paint BACKGROUND = Color.WHITE;
    private Paint PEN_COLOR;
    private Canvas canvas;

    public TurtleDisplay(int width, int height, int padding){
        this.width = width;
        this.height = height;
        this.padding = padding;
        canvas = new Canvas(getFixedWidth(width, padding), getFixedHeight(height, padding));
        getChildren().add(canvas);
        setSizeOfRoot();
        setBackground(new Background(new BackgroundFill(BACKGROUND, CornerRadii.EMPTY, Insets.EMPTY)));
        addTurtleToRoot();
    }
    public void setPEN_COLOR(Paint color){
        PEN_COLOR = color;
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
        turtleImageView = new ImageView(turtleImage);
        getChildren().add(turtleImageView);
        setDefaultTurtleLocation();
    }

    //returns the X position of the turtle at the center of the ImageView
    private double turtleXPosition(){
        return turtleImageView.getX() + turtleImageView.getBoundsInLocal().getWidth()/2;
    }

    //returns the Y position of the turtle at the center of the ImageView
    private double turtleYPosition(){
        return turtleImageView.getY() + turtleImageView.getBoundsInLocal().getHeight()/2;
    }

    /**
     * sets the turtle location to the center of the screen
     */
    public void setDefaultTurtleLocation(){
        turtleImageView.setX(getPrefWidth() / 2);
        turtleImageView.setY(getPrefHeight() / 2);
    }

    // need to work on calculating distance with degrees
    public void moveTurtle(int [][] movement){
        ArrayList<PathTransition> totalMovements = new ArrayList<>();
        for(int[] tup : movement){
            int degrees = tup[0];
            int displacement = tup[1];
            double newWidth = getXDisplacement(degrees, displacement);
            double newHeight = getYDisplacement(degrees, displacement);
            Path path = new Path();
            path.getElements().add(new MoveTo(turtleXPosition(), turtleYPosition()));
            path.getElements().add(new LineTo(turtleXPosition() + newWidth, turtleYPosition() + newHeight));
            turtleImageView.setX(turtleImageView.getX() + newWidth);
            turtleImageView.setY(turtleImageView.getY() + newHeight);
            path.setStroke(Color.RED);
            path.setStrokeWidth(20);
            PathTransition pathTransition = createTransition(path);
            totalMovements.add(pathTransition);
        }
        SequentialTransition sequentialTransition = new SequentialTransition();
        for(PathTransition movements: totalMovements){
            sequentialTransition.getChildren().add(movements);
        }
        sequentialTransition.play();
    }
    private double getXDisplacement(int degrees, int displacement){
        double newY = Math.cos(degrees) * displacement;
        return newY;
    }
    private double getYDisplacement(int degrees, int displacement){
        double newX = Math.sin(degrees) * displacement;
        return newX;
    }

    private PathTransition createTransition(Path path){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setPath(path);
        pathTransition.setNode(turtleImageView);
        pathTransition.setCycleCount(1);
        return pathTransition;

    }
}
