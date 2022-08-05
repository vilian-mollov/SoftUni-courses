package StreamsFilesAndDirectories.lab;

import java.io.*;
import java.util.Scanner;

public class N4ExtractIntegers {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"));
             PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"))) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }

                scanner.next();
            }

        } catch (IOException ignored) {
        }
    }
}
