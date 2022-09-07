package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N6RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        if (n < 2) {
            System.out.println(1);
            return;
        }

        ArrayDeque<Long> stack = new ArrayDeque<>();

        stack.push(0L);    // 0 element of fibonacci
        stack.push(1L);    // 1 element of fibonacci

        for (int i = 1; i < n; i++) {
            long number1 = stack.pop();
            long number2 = stack.pop();

            stack.push(number1);
            stack.push(number1 + number2);
        }


        System.out.println(stack.peek());  // n-th element of fibonacci


    }

}
