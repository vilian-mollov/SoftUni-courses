package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class N1EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        //Peter
        String name = scanner.nextLine();
        int[] numbersFromNames = new int[numberOfStrings];
        for (int j = 0; j < numberOfStrings; j++) {
            String[] nameSeparatedByLetters = name.split("");
            int nameCounter = 0;
            for (int i = 0; i < nameSeparatedByLetters.length; i++) {
                switch (nameSeparatedByLetters[i]) {
                    case "a":
                    case "o":
                    case "e":
                    case "u":
                    case "i":
                    case "A":
                    case "O":
                    case "E":
                    case "I":
                    case "U":
                        char vowel = nameSeparatedByLetters[i].charAt(0);
                        nameCounter += vowel * nameSeparatedByLetters.length;
                        break;
                    default:
                        char constant = nameSeparatedByLetters[i].charAt(0);
                        nameCounter += constant / nameSeparatedByLetters.length;
                        break;

                }
            }
            numbersFromNames[j] = nameCounter;
            if (j == numberOfStrings - 1) {
                continue;
            }
            name = scanner.nextLine();
        }
        Arrays.sort(numbersFromNames);


        for (int s : numbersFromNames) {
            System.out.println(s);
        }

    }
}
