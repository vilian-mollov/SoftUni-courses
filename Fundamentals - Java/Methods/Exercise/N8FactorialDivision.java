package Methods.Exercise;

import java.util.Scanner;

public class N8FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
double factorialOfFirstNumb = 1;
double factorialOfSecondNumb = 1;
double result =0.0;

        factorialOfFirstNumb = getFactorialOfFirstNumb(firstNumber, factorialOfFirstNumb);
        factorialOfSecondNumb = getFactorialOfSecondNumb(secondNumber,factorialOfSecondNumb);

        result = 1.0* factorialOfFirstNumb/factorialOfSecondNumb;
        System.out.printf("%.2f",result);
    }

    private static double getFactorialOfSecondNumb(int secondNumber, double factorialOfSecondNumb) {
        for (int i = 1; i < secondNumber; i++) {
            factorialOfSecondNumb *= i+1;
        }
        return factorialOfSecondNumb;
    }

    private static double getFactorialOfFirstNumb(int firstNumber, double factorialOfFirstNumb) {
        for (int i = 1; i < firstNumber; i++) {
            factorialOfFirstNumb *= i+1;
        }
        return factorialOfFirstNumb;
    }
}
