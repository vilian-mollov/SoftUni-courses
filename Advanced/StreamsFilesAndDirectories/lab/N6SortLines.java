package StreamsFilesAndDirectories.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class N6SortLines {
    public static void main(String[] args) {

        Path inPath = Paths.get("input.txt");
        Path outPath = Paths.get("output.txt");

        try {
            List<String> myList = Files.readAllLines(inPath)
                            .stream()
                                    .sorted().collect(Collectors.toList());
            Files.write(outPath,myList);
        }catch (IOException ignored){}

    }
}
