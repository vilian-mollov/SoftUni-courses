package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class N9Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countsOfOrders = Integer.parseInt(scanner.nextLine());

        double total = 0.0;
        for(int i = 1;i<=countsOfOrders;i++){
            double current = 0.0;
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

          current = ((days*capsuleCount)*pricePerCapsule);
            total+=current;
            System.out.printf("The price for the coffee is: $%.2f%n",current);
        }

        //sout total - ot kolektora .
        System.out.printf("Total: $%.2f",total);

        //((daysInMonth * capsulesCount) * pricePerCapsule)

    }
}
