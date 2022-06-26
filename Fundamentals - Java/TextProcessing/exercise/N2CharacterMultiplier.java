package TextProcessing.exercise;

import java.util.*;

public class N2CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] text = n.split("\\s+");
        String str1 = text[0];
        String str2 = text[1];
        int sum = 0;

        sum = countSum(str1, str2);


        System.out.println(sum);

    }

    public static int countSum(String str1, String str2) {
        int sum = 0;
        int check = 0;
        if (str1.length() > str2.length()) {
            check--;
        } else if (str2.length() > str1.length()) {
            check++;
        }
        int length = 0;
        boolean firstIsLonger = false;
        if (check < 0) {
            length = str1.length();
            firstIsLonger = true;
        } else {
            length = str2.length();
        }

        for (int i = 0; i < length; i++) {
            if (i < length - (Math.abs(str1.length() - str2.length()))) {
                sum += (int) str1.charAt(i) * (int) str2.charAt(i);
            } else {
                if (firstIsLonger) {
                    sum += (int) str1.charAt(i);
                } else {
                    sum += (int) str2.charAt(i);
                }
            }
        }


        return sum;
    }

}
