package StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class N1SumLines {
    public static void main(String[] args) {
String path = "C:\\Users\\user\\Downloads\\01._Sum Lines_Ресурси" +
        "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null){
                long sum =0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }

            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
