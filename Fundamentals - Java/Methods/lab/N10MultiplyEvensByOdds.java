package Methods.lab;

import java.util.Scanner;

public class N10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberAsString = scanner.nextLine();
        String data = numberAsString.replaceAll("[-+]", "");
        int[] numbers = new int[data.length()];
        addingNumbers(numbers,data);
      int sumOfOdd = 0;
      int sumOfEven = 0;

       sumOfOdd= separatingOddsFromEven(numbers, sumOfOdd, sumOfEven);
       sumOfEven = separatingEvenFromOdds(numbers, sumOfOdd, sumOfEven);

        System.out.println(sumOfEven*sumOfOdd);


    }
    private static int separatingEvenFromOdds(int[] numbers, int sumOfOdd, int sumOfEven) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 ==0){
                sumOfEven += numbers[i];
            }else{
                sumOfOdd += numbers[i];
            }
        }
        return sumOfEven;
    }

    private static int separatingOddsFromEven(int[] numbers, int sumOfOdd, int sumOfEven) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 ==0){
                sumOfEven += numbers[i];
            }else{
                sumOfOdd += numbers[i];
            }
        }
        return sumOfOdd;
    }

    private static void addingNumbers(int[] numbers,String data) {
        String[] arrNumbers = data.split("");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arrNumbers[i]);
        }
    }

}
