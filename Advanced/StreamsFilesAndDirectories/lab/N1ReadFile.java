package StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class N1ReadFile {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        try {
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            int Byte = fileInputStream.read();
            while (Byte != -1){
                System.out.print(Integer.toBinaryString(Byte)+" ");
                Byte= fileInputStream.read();
            }
        }catch(IOException ignored){}



    }
}
