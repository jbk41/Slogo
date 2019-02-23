package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;

public class LanguagesDropDown extends HBox{
    private Pane display;
    public LanguagesDropDown(int padding, Pane display){
        super(padding);
        this.display = display;
        createDropDownMenu();
    }
    private void createDropDownMenu(){
        ComboBox<String> languageBox = new ComboBox<>();
        languageBox.setPromptText("Languages");
        languageBox.getItems().addAll(
                "Chinese",
                "English",
                "French",
                "German", "Italian", "Portuguese", "Russian", "Spanish", "Syntax", "Urdu"
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
