package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class PenColorDropDown extends ComboBox {
    private TurtleDisplay turtleDisplay;
    public PenColorDropDown(int padding, TurtleDisplay turtleDisplay){
        this.turtleDisplay = turtleDisplay;
        createDropDownMenu();
    }

    private void createDropDownMenu(){
        setPromptText("Pen Color");
        getItems().addAll(
                "RED", "BLACK", "BLUE", "PURPLE"
        );
        getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Paint color = Paint.valueOf(t1);
                turtleDisplay.setPEN_COLOR(color);
            }
        });
    }
}


