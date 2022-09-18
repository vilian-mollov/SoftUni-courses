package StackAndQueue.exercise;

import java.util.Scanner;

public class N6RecursiveFibonacciDynamicPrograming {
    static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        dp = new long[n+1];

        System.out.println(fibonacci(n));

    }

    private static long fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        return dp[n] = fibonacci(n-1) + fibonacci(n-2);

    }

}
