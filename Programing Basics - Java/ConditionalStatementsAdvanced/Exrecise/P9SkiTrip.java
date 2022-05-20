package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P9SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                int days = Integer.parseInt(scanner.nextLine());
                        String place = scanner.nextLine();
        String rating = scanner.nextLine();
        double discount =0.0;
        double price = 0.0;
        double room = 18.00;
        double apartment = 25.00;
        double president = 35.00;
        double degree = 0.0;


        switch(place){
            case "room for one person":
                price = room * (days - 1);


            break;
            case "apartment":
                price = apartment * (days - 1);
                if(days < 10){
                    discount = 0.30;




                }else if(days >= 10 && days <=15){
                    discount = 0.35;

                }else {
                    discount = 0.50;
                }
            break;
            case "president apartment":
                price = president * (days - 1);
                if(days < 10){
                    discount = 0.10;


                }else if(days >= 10 && days <=15){
                    discount = 0.15;

                }else {
                    discount = 0.20;
                }

            break;
        }
        price  = price - price * discount;

        if(rating.equals("positive")){
            degree = 0.25;
            System.out.printf("%.2f",price + price* degree);


        }else if(rating.equals("negative")){
            degree = 0.10;
            System.out.printf("%.2f",price - price * degree);

        }





    }
}
