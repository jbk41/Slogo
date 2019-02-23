package Visualization;

import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.ArrayList;

public class TurtleDisplay extends Pane{
    private static final String TURTLE_IMAGE = "turtle.gif";
    private double width;
    private double height;
    private int padding;
    private ImageView turtleImageView;
    private Paint BACKGROUND = Color.WHITE;
    private Paint PEN_COLOR;
    private Canvas canvas;
    private SequentialTransition sequentialTransition;

    public TurtleDisplay(double width, double height, int padding){
        this.width = width;
        this.height = height;
        this.padding = padding;
        canvas = new Canvas(getFixedWidth(width,padding), getFixedHeight(height,padding));
        getChildren().add(canvas);
        setSizeOfRoot();
        setBackground(new Background(new BackgroundFill(BACKGROUND, CornerRadii.EMPTY, Insets.EMPTY)));
        addTurtleToRoot();
    }
    public void clearCanvas(){
        getChildren().remove(canvas);
        canvas = new Canvas(getFixedWidth(width,padding), getFixedHeight(height,padding));
        getChildren().add(canvas);

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
        getChildren().remove(turtleImageView);
        getChildren().add(turtleImageView);
        turtleImageView.setX(getPrefWidth() / 2);
        turtleImageView.setY(getPrefHeight() / 2);
    }
    public void moveTurtle(int [][] movement){
        ArrayList<PathTransition> totalMovements = new ArrayList<>();
        sequentialTransition = new SequentialTransition();
        for(int[] tup : movement){
            int degrees = tup[0];
            int displacement = tup[1];
            double newWidth = getXDisplacement(degrees, displacement);
            double newHeight = getYDisplacement(degrees, displacement);
            Path path = new Path();
            path.getElements().add(new MoveTo(turtleXPosition(), turtleYPosition()));
            path.getElements().add(new LineTo(turtleXPosition() + newWidth, turtleYPosition() + newHeight));
            PathTransition pathTransition = createTransition(path);
            totalMovements.add(pathTransition);
            turtleImageView.setX(turtleImageView.getX() + newWidth);
            turtleImageView.setY(turtleImageView.getY() + newHeight);
        }
        for(PathTransition movements: totalMovements){
            sequentialTransition.getChildren().add(movements);
        }
        sequentialTransition.play();
    }
    public void stopTurtle(){
        sequentialTransition.stop();
    }
    private double getXDisplacement(int degrees, int displacement){
        return Math.cos(degrees) * displacement;
    }
    private double getYDisplacement(int degrees, int displacement){
        return Math.sin(degrees) * displacement;
    }

    private PathTransition createTransition(Path path){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setPath(path);
        pathTransition.setNode(turtleImageView);
        pathTransition.setCycleCount(1);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pathTransition.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            double oldX;
            double oldY;
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                double x = turtleImageView.getBoundsInLocal().getCenterX() + turtleImageView.getTranslateX();
                double y = turtleImageView.getBoundsInLocal().getCenterY() + turtleImageView.getTranslateY();
                if(oldX == 0){
                    oldX = x;
                    oldY = y;
                }
                gc.setStroke(PEN_COLOR);
                gc.setLineWidth(4);
                gc.strokeLine(oldX, oldY, x, y);
                oldX = x;
                oldY = y;
            }
        });
        return pathTransition;
    }
}
