package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;

public class ColorDropDown extends HBox{
    private Pane display;
    public ColorDropDown(int padding, Pane display){
        super(padding);
        this.display = display;
        createDropDownMenu();
    }

    private void createDropDownMenu(){
        ComboBox<String> backgroundColorComboBox = new ComboBox<String>();
        backgroundColorComboBox.setPromptText("Background");
        backgroundColorComboBox.getItems().addAll(
                "LIGHTBLUE",
                "WHITE",
                "LIGHTGREEN",
                "LIGHTGRAY"
        );
        backgroundColorComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Paint color = Paint.valueOf(t1);
                display.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        getChildren().add(backgroundColorComboBox);
    }
}
