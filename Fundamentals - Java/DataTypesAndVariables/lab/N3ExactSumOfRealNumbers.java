package DataTypesAndVariables.lab;
import java.math.BigDecimal;
import java.util.Scanner;
public class N3ExactSumOfRealNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal collect = new BigDecimal("0");
        for (int i = 0; i <n ; i++) {
            BigDecimal numbers = scanner.nextBigDecimal();
            collect = collect.add(numbers);
        }
        System.out.println(collect);

    }
}
