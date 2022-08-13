package StreamsFilesAndDirectories.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class N9CopyAPicture {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("warcraft.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("warcraftCopy.jpg")) {
            byte[] bytes = fileInputStream.readAllBytes();
            fileOutputStream.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
