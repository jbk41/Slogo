package Visualization;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


/**
 * This class is used to create the boxes for displaying user defined variables, the history of commands, and the
 * states of the turtles as well.  It is implemented as a ListView so that each individual entry can be clicked and
 * either assigned to a new value in the case of user defined variables or re run in the case of commands.  We need
 * to create these consoles to display meaningful data and enable users to interact with the IDE.
 *
 * @author Bryant Huang, Mark Kang
 */


public class Console extends ListView {
    private int textPadding = 5;
    public Console(double width, double height, int padding, String name){
        ObservableList<String> items = FXCollections.observableArrayList(name);
        setItems(items);
        setPadding(new Insets(textPadding,textPadding,textPadding,textPadding));
        setPrefWidth(width/2 - padding * 2);
        setPrefHeight(height * 0.25 - padding * 3);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

}
