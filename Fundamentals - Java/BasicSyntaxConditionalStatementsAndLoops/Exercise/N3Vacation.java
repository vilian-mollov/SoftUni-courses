package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class N3Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();

        double totalPrice = 0;

        switch (groupType) {
            case "Students":
                if (dayOfTheWeek.equals("Friday")) {
                        totalPrice += 8.45 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    totalPrice += 9.80 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    totalPrice += 10.46 * numberOfPeople;
                }
                //if the group is bigger than or equal to 30 people you should reduce the total price by 15%
                if(numberOfPeople>= 30){
                    totalPrice *= 0.85;
                }


                break;


            case "Business":
                if (dayOfTheWeek.equals("Friday")) {
                    totalPrice += 10.90 * numberOfPeople;
                    if(numberOfPeople>= 100){
                        totalPrice -= 10.90 * 10;
                    }
                } else if (dayOfTheWeek.equals("Saturday")) {
                    totalPrice += 15.60 * numberOfPeople;
                    if(numberOfPeople>= 100){
                        totalPrice -= 15.60 * 10;
                    }
                } else if (dayOfTheWeek.equals("Sunday")) {
                    totalPrice += 16 * numberOfPeople;
                    if(numberOfPeople>= 100){
                        totalPrice -= 16 * 10;
                    }
                }
                //if the group is bigger than or equal to 100 people 10 of them can stay for free.

                break;


            case "Regular":
                if (dayOfTheWeek.equals("Friday")) {
                    totalPrice += 15 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    totalPrice += 20 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    totalPrice += 22.50 * numberOfPeople;
                }
                //•	Regular – if the group is bigger than or equal to 10 and less than or equal to 20 reduce the total price by 5%

                if(numberOfPeople>= 10 && numberOfPeople<= 20){
                    totalPrice*=0.95;
                }
                break;
        }


        System.out.printf("Total price: %.2f", totalPrice);
    }
}
