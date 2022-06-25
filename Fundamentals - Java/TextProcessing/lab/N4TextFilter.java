package TextProcessing.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N4TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        String text = scanner.nextLine();
        List<String> bannedList = new ArrayList<>(Arrays.asList(words.split(", ")));


        for (String bannedWord : bannedList) {
            if(text.contains(bannedWord)){
                String symbol ="*";
                String replacement = symbol.repeat(bannedWord.length());
                text = text.replace(bannedWord,replacement);
            }
        }
        System.out.println(text);

    }
}
