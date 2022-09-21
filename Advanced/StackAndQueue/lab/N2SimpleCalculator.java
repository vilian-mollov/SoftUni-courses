package StackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N2SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = setStack(data);

        int result = 0;
        String operator;

        if(!stack.isEmpty()) {
            int first = Integer.parseInt(stack.pop());
            operator = stack.pop();
            int second = Integer.parseInt(stack.pop());
            result = calculation(result, first, operator, second);
        }

        while (!stack.isEmpty()) {
            operator = stack.pop();
            int number = Integer.parseInt(stack.pop());

            if (operator.equals("+")) {
                result += number;
            } else {
                result -= number;
            }

        }
        System.out.println(result);
    }

    private static int calculation(int result, int first, String operator, int second) {
        if (operator.equals("+")) {
            result += first + second;
        } else {
            result += first - second;
        }
        return result;
    }

    private static ArrayDeque<String> setStack(String[] data) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = data.length - 1; i >= 0; i--) {
            stack.push(data[i]);
        }
        return stack;
    }
}
