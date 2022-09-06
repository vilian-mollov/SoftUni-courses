package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class N4BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementsToEnqueue = data[0];
        int elementsToDequeue = data[1];
        int elementToCheck = data[2];

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        fillDeque(elementsToEnqueue, elements, deque);

        pullElementsFromDeque(elementsToDequeue, deque);

        int smallestElement = Integer.MAX_VALUE;
        boolean isFound = false;

        if (deque.contains(elementToCheck)) {
            System.out.println(true);
        } else if (deque.isEmpty()) {
            System.out.println(0);
        } else {
            while (!deque.isEmpty()){
                int element = deque.poll();
                if (elementToCheck == element) {
                    isFound = true;
                    break;
                }
                if (smallestElement > element) {
                    smallestElement = element;
                    continue;
                }
                deque.poll();

            }
            System.out.println(smallestElement);
        }


    }

    private static void pullElementsFromDeque(int elementsToDequeue, ArrayDeque<Integer> deque) {
        for (int i = 0; i < elementsToDequeue; i++) {
            deque.poll();
        }
    }

    private static void fillDeque(int elementsToEnqueue, int[] elements, ArrayDeque<Integer> deque) {
        for (int i = 0; i < elementsToEnqueue; i++) {
            deque.add(elements[i]);
        }
    }

}
