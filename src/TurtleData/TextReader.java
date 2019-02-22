package TurtleData;

import java.io.*;

public class TextReader {
    private File file;
    public TextReader(File file){
        this.file = file;
    }
    public String getText(){
        String text = "";
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text += line;
                text += "\n";
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
