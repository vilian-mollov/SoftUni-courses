package ExceptionsAndErrorHandling.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int currentNumber = 1;

        List<Integer> numbers = new ArrayList<>();

        while (currentNumber <= 10) {

            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (tryNumber(number, currentNumber, 100)) {
                    currentNumber++;
                    numbers.add(number);
                } else {
                    throw new NumberNotInRangeException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (NumberNotInRangeException ex) {
                System.out.println("Your number is not in range " + currentNumber + " - 100!");
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                System.out.print(numbers.get(i));
                break;
            }
            System.out.print(numbers.get(i) + ", ");
        }


    }

    private static boolean tryNumber(int n, int start, int end) {
        if (n > start && n < end) {
            return true;
        }
        return false;
    }

    public static class NumberNotInRangeException extends Exception {
        public NumberNotInRangeException() {
            super();
        }
    }
}
