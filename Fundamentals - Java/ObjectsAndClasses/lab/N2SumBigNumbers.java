package ObjectsAndClasses.lab;
import java.math.BigInteger;
import java.util.Scanner;

public class N2SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();
        BigInteger sum = n.add(m);
        System.out.println(sum);

    }
}