package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class PenColorDropDown extends HBox {
    private TurtleDisplay display;
    public PenColorDropDown(int padding, TurtleDisplay display){
        super(padding);
        this.display = display;
        createDropDownMenu();
    }

    private void createDropDownMenu(){
        ComboBox<String> penColorComboBox = new ComboBox<String>();
        penColorComboBox.setPromptText("Pen Color");
        penColorComboBox.getItems().addAll(
                "RED", "BLACK", "BLUE", "PURPLE"
        );
        penColorComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Paint color = Paint.valueOf(t1);
                display.setPEN_COLOR(color);
            }
        });
        getChildren().add(penColorComboBox);
    }
}


