package Methods.Exercise;

import java.util.Scanner;

public class N5AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());
int result = sum(one,two);
       result= subtract(result,three);
        System.out.println(result);
    }

    private static int subtract(int result, int three) {
        result = result-three;
        return result;
    }

    private static int sum(int one, int two) {
        int result = one+two;

        return result;
    }
}
