package TurtleData;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TextWriter {
    private File file;
    public TextWriter(File file){
        this.file = file;
    }
    public void writeTextFile(String text){
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
