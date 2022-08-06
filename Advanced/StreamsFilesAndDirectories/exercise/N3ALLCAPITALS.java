package StreamsFilesAndDirectories.exercise;

import java.io.*;

public class N3ALLCAPITALS {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            String line = reader.readLine();

            while (line != null) {
                writer.write(line.toUpperCase() + System.lineSeparator());

                line = reader.readLine();
            }

          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
