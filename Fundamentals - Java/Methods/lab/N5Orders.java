package Methods.lab;

import java.util.Scanner;

public class N5Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double sum=0;
        switch (product) {
            case "coffee":
               sum = calculating(quantity,1.5);
                break;
            case "water":
                sum = calculating(quantity,1.0);
                break;
            case "coke":
                sum = calculating(quantity,1.4);
                break;
            case "snacks":
                sum = calculating(quantity,2.0);
                break;
        }
        System.out.printf("%.2f",sum);
    }
    public static double calculating(int quantity,double price){
        double sum =quantity*price;

return sum;
    }
}
