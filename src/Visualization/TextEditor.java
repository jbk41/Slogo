package Visualization;

import javafx.scene.control.TextArea;
import java.util.Scanner;

public class TextEditor extends TextArea{
    public TextEditor(double width, double height){
        setMaxWidth(width/2 - 30);
        setPrefHeight(height * 0.50);
    }
}
