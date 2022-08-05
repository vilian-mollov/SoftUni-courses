package StreamsFilesAndDirectories.lab;

import java.io.File;
import java.util.Arrays;

public class N7ListFiles {
    public static void main(String[] args) {
        File root = new File("C:\\Users\\user\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName()+": "+ "["+f.length()+"]"));




    }
}
