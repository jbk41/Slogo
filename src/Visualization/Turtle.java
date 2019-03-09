package Visualization;

import Executable.Executable;
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
import Executable.TurtleState;
import Executable.ColorPaletteEntry;
import Executable.EnvironmentState;
import Executable.ErrorMessage;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class Turtle {
    private String TURTLE_IMAGE = "cuteturtle.gif";
    private int ANIMATION_SPEED = 300;
    private ImageView turtleImageView;
    private SequentialTransition sequentialTransition  = new SequentialTransition();
    private TurtleDisplay pane;
    private Canvas canvas;
    private Paint PEN_COLOR;
    private int PEN_SIZE = 4;
    private GraphicsContext gc;
    private double x;
    private double y;
    private double prevDegrees = 0.0;
    private boolean penDown;
    private double myX;
    private double myY;
    private double oldX;
    private double oldY;
    private double myDegrees;
    private double defaultX;
    private double defaultY;
    public Turtle(TurtleDisplay pane, Canvas canvas) {
        this.pane = pane;
        this.canvas = canvas;
        Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
        turtleImageView = new ImageView(turtleImage);
        addTurtleToRoot(TURTLE_IMAGE);
        myX = 0;
        myY = 0;
        prevDegrees = 0;
        myDegrees = 0;
        defaultX = getDefaultX();
        defaultY = getDefaultY();
    }

//    public void setPEN_COLOR(Paint color) {
//        PEN_COLOR = color;
//    }
//
//    public void setPEN_SIZE(int size) {
//        PEN_SIZE = size;
//    }

    public void setAnimationSpeed(int newSpeed) {
        ANIMATION_SPEED = newSpeed;
    }

    private void clearScreen() {
        this.canvas = pane.createNewCanvas();
        gc = canvas.getGraphicsContext2D();
        pane.getChildren().removeAll();
    }

    public void setTurtleImage(String imageName) {
        TURTLE_IMAGE = imageName;
        pane.getChildren().remove(this.turtleImageView);
        addTurtleToRoot(imageName);
    }

    private void addTurtleToRoot(String imageName) {
//        x = turtleImageView.getBoundsInLocal().getCenterX() + turtleImageView.getTranslateX();
//        y = turtleImageView.getBoundsInLocal().getCenterY() + turtleImageView.getTranslateY();
        pane.getChildren().add(this.turtleImageView);
        setDefaultTurtleLocation();
    }

    private double turtleXPosition() {
        return turtleImageView.getX() + turtleImageView.getBoundsInLocal().getWidth() / 2;
    }

    private double turtleYPosition() {
        return turtleImageView.getY() + turtleImageView.getBoundsInLocal().getHeight() / 2;
    }

    /**
     * sets the turtle location to the center of the screen
     */
    public void setDefaultTurtleLocation() {
        turtleImageView.setX(pane.getPrefWidth() / 2 - turtleImageView.getBoundsInParent().getWidth() / 2);
        turtleImageView.setY(pane.getPrefHeight() / 2 - turtleImageView.getBoundsInParent().getHeight() / 2);
    }

    public void moveTurtle(TurtleState currentTurtleState, Console stateConsole) {
        double xAtZero = pane.getPrefWidth() / 2 - turtleImageView.getBoundsInParent().getWidth() / 2;
        double yAtZero = pane.getPrefHeight() / 2 - turtleImageView.getBoundsInParent().getHeight() / 2;
        TurtleState currentTurtle = currentTurtleState;
        myDegrees = currentTurtle.getDeg();
        RotateTransition rt = rotationTransition(turtleImageView, myDegrees, prevDegrees);
        sequentialTransition.getChildren().add(rt);
        prevDegrees = myDegrees;
        System.out.println("oldx and oldy");
        System.out.println(turtleImageView.getX());
        System.out.println(turtleImageView.getY());
        double newX = currentTurtle.getX() + defaultX;
        double newY = defaultY - currentTurtle.getY();
        System.out.println("raw values");
        System.out.println(currentTurtle.getX());
        System.out.println(currentTurtle.getY());
        System.out.println("Temp new values");
        System.out.println(newX);
        System.out.println(newY);
        if (newX == turtleImageView.getX() && newY == turtleImageView.getY()) {
            if (currentTurtle.getClear()) {
                newX = currentTurtle.getX() + xAtZero;
                newY = yAtZero - currentTurtle.getY();
            } else {
                return;
            }
        }
        Path path = new Path();
        path.getElements().add(new MoveTo(turtleImageView.getX(), turtleImageView.getY()));
        path.getElements().add(new LineTo(newX , newY));
        turtleImageView.setX(newX);
        turtleImageView.setY(newY);
        System.out.println("newx and newy");
        System.out.println(turtleImageView.getX());
        System.out.println(turtleImageView.getY());
        PathTransition pathTransition = createTransition(path, currentTurtle, stateConsole);
        sequentialTransition.getChildren().add(pathTransition);
    }


    public SequentialTransition getST(){return sequentialTransition;}

    public void clearST(){sequentialTransition.getChildren().removeAll();}

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
                    gc.setStroke(pane.getPEN_COLOR());
                    gc.setLineWidth(pane.getPEN_SIZE());
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
                stateConsole.getItems().add("Turtle State" + "\r\n" + getState(turtleState.getX(), turtleState.getY(), turtleState.getDeg()%360, turtleState.getPenState()));

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

    String getState(double x, double y, double heading, boolean pen){
        DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.CEILING);
        return "X: " + df.format(x) + "\r\n" + "Y: " + df.format(y) + "\r\n" + "Heading: " + df.format(heading) + "\r\n"  + "Pen: " + pen + "\r\n";
    }

    ImageView getTurtleImageView(){
        return turtleImageView;
    }

    double getDefaultX(){
        return pane.getPrefWidth() / 2 - turtleImageView.getBoundsInParent().getWidth()/2;
    }

    double getDefaultY(){
        return pane.getPrefHeight() / 2 - turtleImageView.getBoundsInParent().getHeight()/2;
    }

    double getCenterX(){
        return 0;
    }

    double getPenSize(){
        return PEN_SIZE;
    }

    GraphicsContext getGraphics(){
        return gc;
    }
}
