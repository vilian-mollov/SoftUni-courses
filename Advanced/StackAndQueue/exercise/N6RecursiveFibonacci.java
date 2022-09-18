package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N6RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque stack = new ArrayDeque<>();

        System.out.println(fibonacci(n,stack));

    }

    private static long fibonacci(int n,ArrayDeque stack) {
        if (n <= 1) {
            return 1;
        }

        stack.push(fibonacci(n - 1,stack) + fibonacci(n - 2,stack));
        return (long)stack.pop();
    }

}
