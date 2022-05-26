package Methods.Exercise;

import java.util.Scanner;

public class N10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {
        String numberAsString =""+i;
        String[] digitsArr = numberAsString.split("");
        boolean havaAnOddDigit = false;
            havaAnOddDigit = findIfItHasAnOddDigit(digitsArr, false);
            if(!havaAnOddDigit){
                continue;
            }
            int theNumberToCheckIfCanDevByEight =0;
            boolean isDividedByEight = false;
            theNumberToCheckIfCanDevByEight = addAllDigitsToANumberToCheckIfItIsDividedByEight(digitsArr, theNumberToCheckIfCanDevByEight);
            if(theNumberToCheckIfCanDevByEight%8==0){
                isDividedByEight=true;
            }

            printTopNumber(numberAsString, isDividedByEight);


        }

    }

    private static void printTopNumber(String numberAsString, boolean isDividedByEight) {
        if(isDividedByEight){
            System.out.println(numberAsString);
            }
    }

    private static int addAllDigitsToANumberToCheckIfItIsDividedByEight(String[] digitsArr, int theNumberToCheckIfCanDevByEight) {
        for (int j = 0; j < digitsArr.length; j++) {
            theNumberToCheckIfCanDevByEight += Integer.parseInt(digitsArr[j]);
        }
        return theNumberToCheckIfCanDevByEight;
    }

    private static boolean findIfItHasAnOddDigit(String[] digitsArr, boolean havaAnOddDigit) {
        for (int j = 0; j < digitsArr.length; j++) {
            if(Integer.parseInt(digitsArr[j]) % 2 != 0 && Integer.parseInt(digitsArr[j])!=0){
                havaAnOddDigit = true;
            }
        }
        return havaAnOddDigit;
    }
}
