package StreamsFilesAndDirectories.lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class N8NestedFolders {
    public static void main(String[] args) throws IOException {
        File root = new File("C:\\Users\\user\\Downloads\\04Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04Java-Advanced-Files-and-Streams-Lab-Resources");

        System.out.println(Files.walk(root.toPath())
                .map(Path::toFile)
                .filter(File::isDirectory)
                .map(File::getName)
                .collect(Collectors.joining(System.lineSeparator())));


    }
}
