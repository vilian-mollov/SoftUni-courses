package Arrays.lab;

import java.util.Scanner;

public class N3SumEvenNumbers {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String n = scanner.nextLine();
String[] arrayOfNumbers = n.split("\\s+");

        int collector =0;
        for (int i = 0; i < arrayOfNumbers.length ; i++) {


            int number = Integer.parseInt(arrayOfNumbers[i]);
            if(number % 2 ==0){
                collector += number;
            }
        }
        System.out.println(collector);
    }
}
