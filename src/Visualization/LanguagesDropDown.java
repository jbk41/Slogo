package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;

class LanguagesDropDown extends HBox{

    LanguagesDropDown(int padding, Pane display){
        super(padding);
        Pane myDisplay = display;
        createDropDownMenu();
    }
    private void createDropDownMenu(){
        ComboBox<String> languageBox = new ComboBox<>();
        languageBox.setPromptText("Languages");
        languageBox.getItems().addAll(
                "Chinese",
                "English",
                "French",
                "German", "Italian", "Portuguese", "Russian", "Spanish", "Urdu"
        );
        languageBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                //TODO: CHANGES LANGUAGE COMMANDS INTERPRETED IN
            }
        });
        getChildren().add(languageBox);
    }
}
