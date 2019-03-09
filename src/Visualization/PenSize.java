package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

public class PenSize extends ComboBox {
    private TurtleDisplay turtleDisplay;
    public PenSize(TurtleDisplay turtleDisplay){
        this.turtleDisplay = turtleDisplay;
        setPromptText("Pen Size");
        getItems().addAll(
                1, 2, 3, 4, 5, 6, 7, 8, 9 ,10, 11, 12,13, 14,15
        );
        getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                    int newSize = Integer.parseInt(t1.toString());
                    turtleDisplay.setPEN_SIZE(newSize);
            }
        });
    }
}
