package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 * This class serves to tell the user how many different pen sizes they can choose from. It gives the user a range of
 * selections so that they can both directly interact with the drop down menu or also run commands with a selected
 * pen size. Creating an object of the class will create the menu for the users. There is also the option to directly
 * click a size from the drop down menu.
 *
 * @author Bryant Huang, Mark Kang
 */

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
