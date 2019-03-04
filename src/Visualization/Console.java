package Visualization;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class Console extends ListView {
    private int textPadding = 5;
//    private TextArea text;
    public Console(double width, double height, int padding, String name){
//        text = new TextArea(name);
//        text.setWrapText(true);
        ObservableList<String> items = FXCollections.observableArrayList(name);
        setItems(items);
        setPadding(new Insets(textPadding,textPadding,textPadding,textPadding));
        setPrefWidth(width/2 - padding * 2);
        setPrefHeight(height * 0.25 - padding * 3);
//        setAlignment(Pos.TOP_LEFT);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

}
