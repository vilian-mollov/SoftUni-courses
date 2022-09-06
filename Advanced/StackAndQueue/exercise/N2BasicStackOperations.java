package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class N2BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementsToPush = inputData[0];
        int elementsToPop = inputData[1];
        int elementToCheck = inputData[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        fillTheStack(elementsToPush, numbers, stack);

        popFromStack(elementsToPop, stack);

        int smallestElement = Integer.MAX_VALUE;
        boolean isFound = false;

        if(stack.contains(elementToCheck)){
            System.out.println(true);
        }else if(stack.isEmpty()){
            System.out.println(0);
        }else{
            while (!stack.isEmpty()) {
                if (elementToCheck == stack.peek()) {
                    isFound = true;
                    break;
                }
                if (smallestElement > stack.peek()) {
                    smallestElement = stack.pop();
               continue;
                }
                stack.pop();

            }
            System.out.println(smallestElement);
        }

    }

    private static void popFromStack(int elementsToPop, ArrayDeque<Integer> stack) {
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }
    }

    private static void fillTheStack(int elementsToPush, int[] numbers, ArrayDeque<Integer> stack) {
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(numbers[i]);
        }
    }
}
