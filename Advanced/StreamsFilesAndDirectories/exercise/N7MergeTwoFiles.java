package StreamsFilesAndDirectories.exercise;

import java.io.*;

public class N7MergeTwoFiles {
    public static void main(String[] args) {

        try (BufferedReader readerOne =  new BufferedReader(new FileReader("inputOne.txt"));
             BufferedReader readerTwo =  new BufferedReader(new FileReader("inputTwo.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            String lineFirstFile =readerOne.readLine();
            while (lineFirstFile!=null){
                writer.write(lineFirstFile + System.lineSeparator());
                lineFirstFile = readerOne.readLine();
            }
            String lineSecondFile = readerTwo.readLine();
            while (lineSecondFile!=null){
                writer.write(lineSecondFile + System.lineSeparator());
                lineSecondFile = readerTwo.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
