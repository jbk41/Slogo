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

/**
 *
 *
 * @author Bryant Huang, Mark Kang
 */

public class ColorDropDown extends ComboBox{
    private Pane display;
    public ColorDropDown(int padding, Pane display){
        this.display = display;
        createDropDownMenu();
    }

    private void createDropDownMenu(){
        setPromptText("Background");
        getItems().addAll(
                "LIGHTBLUE (1)",
                "WHITE (2)",
                "LIGHTGREEN (3)",
                "LIGHTGRAY (4)"
        );
        getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Paint color = Paint.valueOf(t1.split(" ")[0]);
                display.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
    }
    public HashMap<Integer, Paint> getColorMap(){
        HashMap<Integer, Paint> colorMap = new HashMap<>();
        colorMap.put(1, Color.LIGHTBLUE);
        colorMap.put(2, Color.WHITE);
        colorMap.put(3, Color.LIGHTGREEN);
        colorMap.put(4, Color.LIGHTGRAY);
        return colorMap;
    }
}
