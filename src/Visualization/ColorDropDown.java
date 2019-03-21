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
 * This class is utilized to create a palette for the color selections. It enables the users to see which
 * colors are mapped to which numbers, and with this number the user can type a command that changes the color of the
 * turtle environment background. Creating an instance of this class is all that is necessary to create the
 * visualization that the user can see and interact with. The user also has the option to select directly from the
 * drop down menu.
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
