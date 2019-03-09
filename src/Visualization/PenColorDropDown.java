package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;

public class PenColorDropDown extends ComboBox {
    private TurtleDisplay turtleDisplay;
    public PenColorDropDown(int padding, TurtleDisplay turtleDisplay){
        this.turtleDisplay = turtleDisplay;
        createDropDownMenu();
    }

    private void createDropDownMenu(){
        setPromptText("Pen Color");
        getItems().addAll(
                "RED (1) ", "BLACK (2)", "BLUE (3)", "PURPLE (4)"
        );
        getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Paint color = Paint.valueOf(t1);
                turtleDisplay.setPEN_COLOR(color);
            }
        });
    }

    public HashMap<Integer, Paint> getColorMap(){
        HashMap<Integer, Paint> colorMap = new HashMap<>();
        colorMap.put(1, Color.RED);
        colorMap.put(2, Color.BLACK);
        colorMap.put(3, Color.BLUE);
        colorMap.put(4, Color.PURPLE);
        return colorMap;
    }
}


