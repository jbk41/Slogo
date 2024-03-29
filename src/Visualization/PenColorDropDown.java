package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;

/**
 * This class creates a palette for the user to choose from different pen colors and see what numerical values that
 * they are mapped to, so that they can run commands that will change the pen color.  Creating an object of the class
 * will create the visualization component, from which users can click to see their available color selections and
 * the appropriate mapping. The user also has a built in option of selecting directly from the drop down menu.
 *
 * @author Bryant Huang, Mark Kang
 */

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


