package StreamsFilesAndDirectories.lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2WriteToAFile {
    public static void main(String[] args) {
        String programDir = System.getProperty("user.dir");
        String path = "\\input.txt";
        String outPath = "\\output.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols,',', '.', '!', '?');

        try (InputStream in = new FileInputStream(programDir + path); OutputStream out = new FileOutputStream(programDir+outPath)) {


            int oneByte = in.read();
            while (oneByte >= 0){
                if(!symbols.contains((char)oneByte)){
                    out.write(oneByte);
                }
                oneByte = in.read();
            }

        } catch (IOException e) {

        }


    }
}
