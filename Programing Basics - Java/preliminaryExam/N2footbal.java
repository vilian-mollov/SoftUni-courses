package preliminaryExam;

import java.util.Scanner;

public class N2footbal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceOfTshirt = Double.parseDouble(scanner.nextLine());
        double neededPrice = Double.parseDouble(scanner.nextLine());
        double priceOfshorts = priceOfTshirt * 0.75;
        double priceOfsocks = priceOfshorts * 0.20;
        double boots = (priceOfTshirt + priceOfshorts) * 2;
        double total = priceOfshorts + priceOfTshirt + priceOfsocks + boots;
        total = total - total * 0.15;


        if( total >= neededPrice){
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", total);

        }else{
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", neededPrice - total);


        }
    }
}
