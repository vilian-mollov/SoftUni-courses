package TextProcessing.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N2RepeatStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        List<String> repeated = new ArrayList<>();
        for (String word : words){
            repeated.add(repeated(word,word.length()));
        }
        for (String s : repeated) {
            System.out.print(s);
        }


    }

    public static String repeated(String word,int n) {
        char[] repeated = new char[n * n];
        for (int i = 0; i < repeated.length; i++) {
            repeated[i] = word.charAt(i % n);
        }

        return new String(repeated);
    }

}