package StreamsFilesAndDirectories.exercise;

import java.io.*;

public class N5LineNumbers {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("inputLineNumbers.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){

            String line = reader.readLine();
            int counter = 0;
            while (line != null) {
                counter++;
                writer.write(counter+". ");
                writer.write(line + System.lineSeparator());
                line = reader.readLine();
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
