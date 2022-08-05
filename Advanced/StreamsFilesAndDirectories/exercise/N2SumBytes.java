package StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class N2SumBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Downloads\\01._Sum Lines_Ресурси" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            BigInteger sum = new BigInteger("0");
            while (line != null){
                for (int i = 0; i < line.length(); i++) {
                    sum = sum.add(BigInteger.valueOf(line.charAt(i)));
                }
                line = reader.readLine();
            }

            System.out.println(sum);
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}