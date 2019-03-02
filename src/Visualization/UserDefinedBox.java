package Visualization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class UserDefinedBox extends Label{

    //FIXME: REDUNDANT globals below, just testing for now
    private static final int width = 1050;
    private static final int height = 680;
    private static final int padding = 5;

    public UserDefinedBox(String name){
        setText(name);
        setAlignment(Pos.TOP_LEFT);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefWidth(width/4 - padding*2);
        setPrefHeight(height * 0.25 - padding *2);
        setPadding(new Insets(padding,padding,padding,padding));
    }
}
