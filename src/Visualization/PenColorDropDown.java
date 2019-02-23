package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class PenColorDropDown extends HBox {
    private Turtle turtle;
    public PenColorDropDown(int padding, Turtle turtle){
        super(padding);
        this.turtle = turtle;
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
                turtle.setPEN_COLOR(color);
            }
        });
        getChildren().add(penColorComboBox);
    }
}


