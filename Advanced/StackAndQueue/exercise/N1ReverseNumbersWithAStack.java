package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class N1ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        addNumbersToStack(numbers, stack);


        for (Integer integer : stack) {
            System.out.print(stack.pop()+" ");
        }


    }

    private static void addNumbersToStack(int[] numbers, ArrayDeque<Integer> stack) {
        for (Integer number : numbers) {
            stack.push(number);
        }
    }
}
