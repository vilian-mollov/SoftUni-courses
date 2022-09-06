package StackAndQueue.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N3MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            List<Integer> commandAndValue = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int command = commandAndValue.get(0);


            switch (command) {
                case 1:
                    int value = commandAndValue.get(1);
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                   /* System.out.println(Collections.max(stack)); - same as */
                    int maxElement = getMaxElement(stack);
                    System.out.printf("%d%n",maxElement);
                    break;
            }

        }


    }

    private static int getMaxElement(ArrayDeque<Integer> stack) {
        ArrayDeque<Integer> stackParam = new ArrayDeque<>(stack);

        int maxElement = Integer.MIN_VALUE;
       while (!stackParam.isEmpty()) {
           if (stackParam.peek() > maxElement) {
               maxElement = stackParam.pop();
               continue;
           }
           stackParam.pop();
       }
            return maxElement;
    }

}