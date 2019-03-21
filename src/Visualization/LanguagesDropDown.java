package Visualization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;

/**
 * This class gives the user the option to select a language in which to run the commands. There are a set number of
 * languages that the user chooses from, so there are no potential errors in language selection. When the code
 * executes it obtains the string from this drop down menu and then interprets commands in that specific language.
 * Creating an object of the class will create this menu for the user.
 *
 * @author Bryant Huang, Mark Kang
 */

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
