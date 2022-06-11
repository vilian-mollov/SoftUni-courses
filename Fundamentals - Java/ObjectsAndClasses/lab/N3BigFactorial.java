package ObjectsAndClasses.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class N3BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }
}
//30414093201713378043612608166064768844377641568960512000000000000
//30414093201713378043612608166064768844377641568960512000000000000