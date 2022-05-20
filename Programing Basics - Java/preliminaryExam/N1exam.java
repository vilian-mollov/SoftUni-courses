package preliminaryExam;

import java.util.Scanner;

public class N1exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceProcessors = Double.parseDouble(scanner.nextLine());
        double priceVideoCard = Double.parseDouble(scanner.nextLine());
        double priceRam = Double.parseDouble(scanner.nextLine());
        int numberOfRam = Integer.parseInt(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());

        double total = (priceProcessors + priceVideoCard) - (priceProcessors + priceVideoCard) * discount + priceRam * numberOfRam;


        System.out.printf("Money needed - %.2f leva.", total * 1.57);
    }
}
