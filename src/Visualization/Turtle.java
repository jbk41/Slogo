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
    private SequentialTransition sequentialTransition;
    private TurtleDisplay pane;
    private Canvas canvas;
    private Paint PEN_COLOR;
    private int PEN_SIZE = 4;
    private GraphicsContext gc;
    private double x;
    private double y;
    private double oldX;
    private double oldY;
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

    public void setAnimationSpeed(int newSpeed){
        ANIMATION_SPEED = newSpeed;
    }
    private void clearScreen(){
        this.canvas = pane.createNewCanvas();
        gc = canvas.getGraphicsContext2D();
        setTurtleImage(TURTLE_IMAGE);
    }
    public void setTurtleImage(String imageName){
        TURTLE_IMAGE = imageName;
        pane.getChildren().remove(this.turtleImageView);
        addTurtleToRoot(imageName);
    }
    private void addTurtleToRoot(String imageName){
        Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(imageName));
        this.turtleImageView = new ImageView(turtleImage);
        x = turtleImageView.getBoundsInLocal().getCenterX() + turtleImageView.getTranslateX();
        y = turtleImageView.getBoundsInLocal().getCenterY() + turtleImageView.getTranslateY();
        pane.getChildren().add(this.turtleImageView);
        setDefaultTurtleLocation();
    }

    private double turtleXPosition(){
        return turtleImageView.getX() + turtleImageView.getBoundsInLocal().getWidth()/2;
    }

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
    public void moveTurtle(List<Executable> turtleStateList, Console stateConsole) {
        sequentialTransition = new SequentialTransition();
        double defaultX = turtleXPosition();
        double defaultY = turtleYPosition();
        double xAtZero = pane.getPrefWidth() / 2 - turtleImageView.getBoundsInParent().getWidth() / 2;
        double yAtZero = pane.getPrefHeight() / 2 - turtleImageView.getBoundsInParent().getHeight() / 2;
        double prevDegrees = 0.0;
        for (int x = 0; x < turtleStateList.size(); x++) {
            Executable currentTurtleState = turtleStateList.get(x);
            if(currentTurtleState instanceof TurtleState) {
                TurtleState currentTurtle = (TurtleState)currentTurtleState;
                double degrees = currentTurtle.getDeg();
                RotateTransition rt = rotationTransition(turtleImageView, degrees, prevDegrees);
                sequentialTransition.getChildren().add(rt);
                prevDegrees = degrees;
                double newX = currentTurtle.getX() + defaultX;
                double newY = defaultY - currentTurtle.getY();
                if(turtleXPosition() == newX && turtleYPosition() == newY){
                    if(currentTurtle.getClear()){
                        newX = currentTurtle.getX() + xAtZero;
                        newY = yAtZero - currentTurtle.getY();
                    }else{
                        continue;
                    }
                }
                Path path = new Path();
                path.getElements().add(new MoveTo(turtleXPosition(), turtleYPosition()));
                System.out.println("original: ");
                System.out.println(turtleXPosition());
                System.out.println(turtleYPosition());
                path.getElements().add(new LineTo(newX, newY));
                System.out.println("move to: ");
                System.out.println(newX);
                System.out.println(newY);
                turtleImageView.setX(newX - turtleImageView.getBoundsInLocal().getWidth()/2);
                turtleImageView.setY(newY - turtleImageView.getBoundsInLocal().getHeight()/2);
                PathTransition pathTransition = createTransition(path, currentTurtle, stateConsole);
                sequentialTransition.getChildren().add(pathTransition);
            }
            if(currentTurtleState instanceof EnvironmentState){
            }
            if(currentTurtleState instanceof ErrorMessage){
                stateConsole.getItems().add(((ErrorMessage) turtleStateList).getError());
            }
            if(currentTurtleState instanceof ColorPaletteEntry){
                double r = ((ColorPaletteEntry) turtleStateList).getR();
                double b = ((ColorPaletteEntry) turtleStateList).getB();
                double g = ((ColorPaletteEntry) turtleStateList).getG();
            }
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
                if(!turtleState.getPenState()) {
                    gc.setStroke(PEN_COLOR);
                    gc.setLineWidth(PEN_SIZE);
                    gc.strokeLine(oldX, oldY, x, y);
                }
                oldX = x;
                oldY = y;
                if(turtleState.getClear()){clearScreen();}
                if(checkWidthOutOfBounds(x) || checkHeightOutOfBounds(y) || turtleState.getVisibility()){
                    turtleImageView.setVisible(false);
                }else{
                    turtleImageView.setVisible(true);
                }
                stateConsole.getItems().clear();
                stateConsole.getItems().add("Turtle State" + "\r\n" + getState(turtleState.getX(), turtleState.getY(), turtleState.getDeg(), turtleState.getPenState()));

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
