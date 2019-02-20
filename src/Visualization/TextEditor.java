package Visualization;

import javafx.scene.control.TextArea;

public class TextEditor extends TextArea{
    public TextEditor(int width, int height){
        setMaxWidth(width/2 - 30);
        setPrefHeight(height * 0.75);
    }
}
