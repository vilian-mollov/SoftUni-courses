package ExceptionsAndErrorHandling.lab;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Range: [" + range[0] + "..." + range[1] + "]");

        while (true) {
            String text = scanner.nextLine();
            int number;
            try {
                number = Integer.parseInt(text);
                if (number >= range[0] && number <= range[1]) {
                    System.out.println("Valid number: " + number);
                    break;
                } else {
                    throw new MyException("Invalid number: " + number);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + text);
            } catch (MyException myEx) {
                System.out.println(myEx.getMessage());
            }


        }


    }

    public static class MyException extends Exception {
        public MyException(String msg) {
            super(msg);
        }

    }


}
