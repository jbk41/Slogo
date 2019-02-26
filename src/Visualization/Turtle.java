package Visualization;

import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;

public class Turtle {
    private static final String TURTLE_IMAGE = "turtle.gif";
    private ImageView turtleImageView;
    private SequentialTransition sequentialTransition;
    private Pane pane;
    private Canvas canvas;
    private Paint PEN_COLOR;
    private double xPos;
    private double yPos;
    private double direction;

    public Turtle(Pane pane, Canvas canvas){
        this.pane = pane;
        this.canvas = canvas;
        addTurtleToRoot();
    }
    public void changeCanvas(Canvas canvas){
        this.canvas = canvas;
    }
    private void addTurtleToRoot(){
        Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
        turtleImageView = new ImageView(turtleImage);
        pane.getChildren().add(turtleImageView);
        setDefaultTurtleLocation();
    }
    public void setPEN_COLOR(Paint color){
        PEN_COLOR = color;
    }


    //returns the X position of the turtle at the center of the ImageView
    private double turtleXPosition(){
        return turtleImageView.getX() + turtleImageView.getBoundsInLocal().getWidth()/2;
    }

    //returns the Y position of the turtle at the center of the ImageView
    public double turtleYPosition(){
        return turtleImageView.getY() + turtleImageView.getBoundsInLocal().getHeight()/2;
    }

    /**
     * sets the turtle location to the center of the screen
     */
    public void setDefaultTurtleLocation(){
        turtleImageView.setX(pane.getPrefWidth() / 2 - turtleImageView.getBoundsInParent().getWidth()/2);
        turtleImageView.setY(pane.getPrefHeight() / 2 - turtleImageView.getBoundsInParent().getHeight()/2);
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
            //TODO: if
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
        return Math.cos(Math.toRadians(degrees)) * displacement;
    }
    private double getYDisplacement(int degrees, int displacement){
        return Math.sin(Math.toRadians(degrees)) * displacement;
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
                if(checkWidthOutOfBounds(x) || checkHeightOutOfBounds(y)){
                    turtleImageView.setVisible(false);
                }else{
                    turtleImageView.setVisible(true);
                }
            }
        });
        return pathTransition;
    }
    private Boolean checkWidthOutOfBounds(double x){
        return x < 0 || x > pane.getPrefWidth();
    }
    private Boolean checkHeightOutOfBounds(double y){
        return y < 0 || y > pane.getPrefHeight();
    }
}
