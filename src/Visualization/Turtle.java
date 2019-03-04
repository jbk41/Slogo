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
import javafx.scene.paint.Paint;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import TurtleState.TurtleState;
import java.util.List;

public class Turtle {
    private String TURTLE_IMAGE = "cuteturtle.gif";
    private int ANIMATION_SPEED = 300;
    private ImageView turtleImageView;
    private SequentialTransition sequentialTransition;
    private TurtleDisplay pane;
    private Canvas canvas;
    private Paint PEN_COLOR;
    private int PEN_SIZE = 4;
    private GraphicsContext gc;

    public Turtle(TurtleDisplay pane, Canvas canvas){
        this.pane = pane;
        this.canvas = canvas;
        addTurtleToRoot(TURTLE_IMAGE);
    }
    public void setPEN_COLOR(Paint color){
        PEN_COLOR = color;
    }
    public void setPEN_SIZE(int size){
        PEN_SIZE = size;
    }

    public void setTurtleImage(String imageName){
        TURTLE_IMAGE = imageName;
        pane.getChildren().remove(turtleImageView);
        addTurtleToRoot(imageName);
    }

    public void setAnimationSpeed(int newSpeed){
        ANIMATION_SPEED = newSpeed;
    }
    private void clearScreen(){
        this.canvas = pane.createNewCanvas();
        gc = canvas.getGraphicsContext2D();
        setTurtleImage(TURTLE_IMAGE);
    }
    private void addTurtleToRoot(String imageName){
        Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(imageName));
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
    public void moveTurtle(List<TurtleState> turtleStateList, Console stateConsole){
        sequentialTransition = new SequentialTransition();
        double defaultX = turtleXPosition();
        double defaultY = turtleYPosition();
        double xAtZero = pane.getPrefWidth() / 2 - turtleImageView.getBoundsInParent().getWidth()/2;
        double yAtZero = pane.getPrefHeight() / 2 - turtleImageView.getBoundsInParent().getHeight()/2;
        double prevDegrees = 0.0;
        for(int x = 0; x < turtleStateList.size(); x ++){
            TurtleState currentTurtleState = turtleStateList.get(x);
            double degrees = currentTurtleState.getMyDegrees();
            RotateTransition rt = rotationTransition(turtleImageView, degrees, prevDegrees);
            sequentialTransition.getChildren().add(rt);
            prevDegrees = degrees;
            double newX = currentTurtleState.getXPos() + defaultX;
            double newY = defaultY - currentTurtleState.getYPos();
            if(turtleXPosition() == newX && turtleYPosition() == newY){
                if(currentTurtleState.getClear()){
                    newX = currentTurtleState.getXPos() + xAtZero;
                    newY = yAtZero - currentTurtleState.getYPos();
                }else{
                    continue;
                }
            }
            Path path = new Path();
            path.getElements().add(new MoveTo(turtleXPosition(), turtleYPosition()));
            path.getElements().add(new LineTo(newX, newY));
            turtleImageView.setX(newX - turtleImageView.getBoundsInLocal().getWidth()/2);
            turtleImageView.setY(newY - turtleImageView.getBoundsInLocal().getHeight()/2);
            PathTransition pathTransition = createTransition(path, turtleStateList.get(x), stateConsole);
            sequentialTransition.getChildren().add(pathTransition);
        }
        sequentialTransition.play();

    }
    private RotateTransition rotationTransition(ImageView turtleImageView, double degrees, double prevDegrees){
        RotateTransition rt = new RotateTransition(Duration.millis(ANIMATION_SPEED), turtleImageView);
        rt.setByAngle(degrees - prevDegrees);
        rt.setCycleCount(1);
        return rt;

    }
    private PathTransition createTransition(Path path, TurtleState turtleState, Console stateConsole){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(ANIMATION_SPEED));
        pathTransition.setPath(path);
        pathTransition.setNode(turtleImageView);
        pathTransition.setCycleCount(1);
        gc = canvas.getGraphicsContext2D();
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
                    gc.setLineWidth(PEN_SIZE);
                    gc.strokeLine(oldX, oldY, x, y);
                }
                oldX = x;
                oldY = y;
                if(turtleState.getClear()){clearScreen();}
                if(checkWidthOutOfBounds(x) || checkHeightOutOfBounds(y) || !turtleState.getVisibility()){
                    turtleImageView.setVisible(false);
                }else{
                    turtleImageView.setVisible(true);
                }
                stateConsole.getItems().clear();
                stateConsole.getItems().add("Turtle State" + "\r\n" + getState(turtleState.getXPos(), turtleState.getYPos(), turtleState.getMyDegrees(), turtleState.getPenDown()));

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

    public String getState(double x, double y, double heading, boolean pen){
        return "X: " + x + "\r\n" + "Y: " + y + "\r\n" + "Heading: " + heading + "\r\n"  + "Pen: " + pen + "\r\n";
    }
}
