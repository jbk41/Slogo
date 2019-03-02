package Visualization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Console extends Label{
    private int textPadding = 5;
    public Console(double width, double height, int padding, String name){
        setText(name);
        setPadding(new Insets(textPadding,textPadding,textPadding,textPadding));
        setPrefWidth(width/2 - padding * 2);
        setPrefHeight(height * 0.25 - padding * 3);
        setAlignment(Pos.TOP_LEFT);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }



}
