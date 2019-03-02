package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;

class LanguagesDropDown extends ComboBox{

    LanguagesDropDown(){
        createDropDownMenu();
    }
    private void createDropDownMenu(){
        setPromptText("Languages");
        getItems().addAll(
                "Chinese",
                "English",
                "French",
                "German", "Italian", "Portuguese", "Russian", "Spanish", "Urdu"
        );
    }
}
