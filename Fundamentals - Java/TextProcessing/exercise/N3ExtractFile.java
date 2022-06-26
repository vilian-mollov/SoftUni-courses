package TextProcessing.exercise;

import java.util.*;

public class N3ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileInfo = scanner.nextLine();
        List<String>file = new ArrayList<>(Arrays.asList(fileInfo.split("[\\\\.]+")));

        System.out.println("File name: "+file.get(file.size()-2));
        System.out.println("File extension: "+file.get(file.size()-1));


    }
}
