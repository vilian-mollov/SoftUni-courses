package Arrays.MoreExercise;

import java.util.Scanner;

public class N3RecursiveFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n));

    }
    private static long fibonacci (int n){
        if(n<=1){
return n;
        }
        return (fibonacci(n-1)+fibonacci(n-2));

    }
}
