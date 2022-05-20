package DataTypesAndVariables.lab;

import java.util.Scanner;

public class N12RefactorSpecialNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        boolean isSpecial = false;

        for (int i = 1; i <= n; i++) {
            int lastDigit = i%10;
            int firstDigit = (i-lastDigit)/10;

            isSpecial = (lastDigit + firstDigit == 5) || (lastDigit + firstDigit == 7) || (lastDigit + firstDigit == 11);
            if(isSpecial) {
                System.out.printf("%d -> True%n", i);
            }else{
                System.out.printf("%d -> False%n", i);
            }



        }
    }
}