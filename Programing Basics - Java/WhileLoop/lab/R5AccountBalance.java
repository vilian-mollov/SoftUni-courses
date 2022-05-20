package WhileLoop.lab;

import java.util.Scanner;

public class R5AccountBalance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double sum = 0.0;



        String payment = scanner.nextLine();
        while(!payment.equals("NoMoreMoney")){

            double pay = Double.parseDouble(payment);

            if(pay < 0) {
                System.out.println("Invalid operation!");
                break;
            }else {
                System.out.printf("Increase: %.2f%n", pay);
                sum += pay;
            }
            payment = scanner.nextLine();

        }
        System.out.printf("Total: %.2f", sum);


    }
}
