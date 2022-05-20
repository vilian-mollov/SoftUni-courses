package Arrays.Exercise;

import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class N3ZigZagArrays {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];


        for (int i = 1; i <= n; i++) {
            String inputAsString = scanner.nextLine();

            String[] items = inputAsString.split(" ");
            int[] arr = Arrays.stream(items)
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            int integerOne = 0;
            int integerTwo = 0;
            for (int j = 0; j < 1; j++) {
                integerOne = arr[j];
                integerTwo = arr[j + 1];
            }


            if (i == 1) {
                arrayOne[i - 1] = integerOne;
                arrayTwo[i - 1] = integerTwo;
            }
            if (i % 2 == 0) {
                arrayOne[i - 1] = integerTwo;
                arrayTwo[i - 1] = integerOne;
            }
            if (i % 2 != 0 && i != 1) {
                arrayOne[i - 1] = integerOne;
                arrayTwo[i - 1] = integerTwo;
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.print(arrayOne[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arrayTwo[i] + " ");
        }
    }
}
