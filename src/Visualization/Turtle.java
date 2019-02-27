package Visualization;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
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
import TurtleState.TurtleState;

import java.util.ArrayList;
import java.util.List;

public class Turtle {
    private static final String TURTLE_IMAGE = "turtle.gif";
    private ImageView turtleImageView;
    private SequentialTransition sequentialTransition;
    private Pane pane;
    private Canvas canvas;
    private Paint PEN_COLOR;

    public Turtle(Pane pane, Canvas canvas){
        this.pane = pane;
        this.canvas = canvas;
        addTurtleToRoot();
    }
    public void changeCanvas(Canvas canvas){
        this.canvas = canvas;
    }
    public void setPEN_COLOR(Paint color){
        PEN_COLOR = color;
    }

    private void addTurtleToRoot(){
        Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
        turtleImageView = new ImageView(turtleImage);
        pane.getChildren().add(turtleImageView);
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
        turtleImageView.setX(pane.getPrefWidth() / 2 - turtleImageView.getBoundsInParent().getWidth()/2);
        turtleImageView.setY(pane.getPrefHeight() / 2 - turtleImageView.getBoundsInParent().getHeight()/2);
    }
    public void moveTurtle(List<TurtleState> turtleStateList){
        sequentialTransition = new SequentialTransition();
        double defaultX = turtleXPosition();
        double defaultY = turtleYPosition();
        for(TurtleState currentTurtleState: turtleStateList){
            double degrees = currentTurtleState.getMyDegrees();
            RotateTransition rt = rotationTransition(turtleImageView, degrees);
            sequentialTransition.getChildren().add(rt);
            double newX = currentTurtleState.getXPos() + defaultX;
            double newY = defaultY - currentTurtleState.getYPos();
            Path path = new Path();
            path.getElements().add(new MoveTo(turtleXPosition(), turtleYPosition()));
            path.getElements().add(new LineTo(newX, newY));
            turtleImageView.setX(newX - turtleImageView.getBoundsInLocal().getWidth()/2);
            turtleImageView.setY(newY - turtleImageView.getBoundsInLocal().getHeight()/2);
            PathTransition pathTransition = createTransition(path, currentTurtleState);
            sequentialTransition.getChildren().add(pathTransition);
        }

        sequentialTransition.play();
    }
    private RotateTransition rotationTransition(ImageView turtleImageView, double degrees){
        RotateTransition rt = new RotateTransition(Duration.millis(3000), turtleImageView);
        rt.setByAngle(90);
        rt.setCycleCount(1);
        return rt;

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

    private PathTransition createTransition(Path path, TurtleState turtleState){
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
                if(turtleState.getPenState()) {
                    gc.setStroke(PEN_COLOR);
                    gc.setLineWidth(4);
                    gc.strokeLine(oldX, oldY, x, y);
                }
                oldX = x;
                oldY = y;
                if(checkWidthOutOfBounds(x) || checkHeightOutOfBounds(y) || !turtleState.getVisibility()){
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
