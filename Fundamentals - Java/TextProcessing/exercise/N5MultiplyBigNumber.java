package TextProcessing.exercise;

import java.util.*;

public class N5MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        if (multiplier == 0) {
            System.out.println("0");
            return;
        }else if(multiplier == 1){
            System.out.println(number);
            return;
        }

        int reminder = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            int product = digit * multiplier + reminder;
            if (i == 0) {
                if(product>0){
                    stringBuilder.insert(0, product);
                }
            } else {
                if(product>0) {
                    stringBuilder.insert(0, product % 10);
                    reminder = product / 10;
                }
            }
        }
        System.out.println(stringBuilder);
    }

}