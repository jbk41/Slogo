//package Visualization;
//
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.geometry.Insets;
//import javafx.scene.Node;
//import javafx.scene.control.ComboBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.Paint;
//
//import java.util.HashMap;
//
//public class ImageDropDown extends ComboBox {
//    private Pane display;
//    public ImageDropDown(int padding, Pane display){
//        this.display = display;
//        createDropDownMenu();
//    }
//
//    private void createDropDownMenu(){
//        setPromptText("Background");
//        getItems().addAll(
//                "Cute Turtle (1)",
//                "Regular Turtle (2)"
//        );
//        getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
//                for (Node node : display.getChildren()){
//                    if ()
//                }
//            }
//        });
//    }
//    public HashMap<Integer, Paint> getColorMap(){
//        HashMap<Integer, Paint> colorMap = new HashMap<>();
//        colorMap.put(1, Color.LIGHTBLUE);
//        colorMap.put(2, Color.WHITE);
//        colorMap.put(3, Color.LIGHTGREEN);
//        colorMap.put(4, Color.LIGHTGRAY);
//        return colorMap;
//    }
//}
