package Methods.lab;

import java.util.Scanner;

public class N4Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case "add":
                add(numberOne,numberTwo);
                break;
            case "subtract":
                subtract(numberOne, numberTwo);
                break;
            case "divide":
                divide(numberOne,numberTwo);
                break;
            case "multiply":
                multiply(numberOne,numberTwo);
                break;
        }

    }
    public static void multiply(int numberOne, int numberTwo){
        System.out.println(numberOne*numberTwo);
    }
    static void divide(int numberOne,int numberTwo){
        System.out.println(numberOne/numberTwo);
    }

     static void add(int numberOne, int numberTwo) {
         System.out.println(numberOne+numberTwo);
    }

    static void subtract(int one, int two) {
        System.out.println(Math.abs(one - two));
    }
}
