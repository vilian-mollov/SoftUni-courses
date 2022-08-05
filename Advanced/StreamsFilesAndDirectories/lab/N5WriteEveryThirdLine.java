package StreamsFilesAndDirectories.lab;

import java.io.*;

public class N5WriteEveryThirdLine {
    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"));
             PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"))) {
            int numberOfLine = 1;
            String line = in.readLine();
            while (line != null) {
                if (numberOfLine % 3 == 0) {
                    out.println(line);
                }
                numberOfLine++;
                line = in.readLine();
            }

        } catch (IOException ignored) {
        }
    }
}
