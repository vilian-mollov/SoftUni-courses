package StreamsFilesAndDirectories.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class N8GetFolderSize {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File root = new File(path);
        long size = 0;
        Stream<Path> walk = Files.walk(root.toPath());
        size = getFileSize(walk);

        System.out.println("Folder size: " + size);
    }

    private static long getFileSize(Stream<Path> walk) {
        return walk.filter(Files::isRegularFile).mapToLong(p -> {
                    try {
                        return Files.size(p);
                    } catch (IOException e) {
                        System.out.printf("Failed to get size of %s%n%s", p, e);
                        return 0L;
                    }
                })
                .sum();
    }
}
