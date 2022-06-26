package TextProcessing.exercise;

import java.util.*;

public class N4CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String encrypted = "";

        char[] textSplited = text.toCharArray();
        for (int i = 0; i < textSplited.length; i++) {
            int first = textSplited[i];
            first+=3;
            encrypted+= (char) first;
        }

        System.out.println(encrypted);
    }
}
