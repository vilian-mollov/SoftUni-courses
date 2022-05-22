package Methods.Exercise;

import java.util.Scanner;

public class N2VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int result = 0;
        result = calculatingTheCountOfVowels(text);
        System.out.println(result);

    }

    static int calculatingTheCountOfVowels(String text) {
        int result = 0;
        String[] textArr = text.split("");
        for (int i = 0; i < textArr.length; i++) {
            switch (textArr[i]) {
                case "a":
                case "o":
                case "u":
                case "e":
                case "i":
                case "A":
                case "O":
                case "U":
                case "E":
                case "I":
                    result += 1;
                    break;

            }
        }

        return result;
    }
}
