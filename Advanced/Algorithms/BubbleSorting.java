package Algorithms;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 2, 5, 6, 0, 21, 78, 13, 42, 11, 10, 1};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int tempNumber = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tempNumber;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));

    }
}
