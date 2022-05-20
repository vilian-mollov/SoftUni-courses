package MoreExercises;

import java.util.Scanner;

public class BikeRace {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberJunior = Integer.parseInt(scanner.nextLine());
        int numberSenior = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
double total = 0.0;



            switch(type){
                case "trail":
                    total+= numberJunior * 5.5;
                        total+= numberSenior * 7;
                    break;
                case "cross-country":
                    total+= numberJunior * 8;
                    total+= numberSenior * 9.5;
                    if(numberJunior+numberSenior >= 50){
                        total -= total * 0.25;
                    }
                    break;
                case "downhill":
                    total+= numberJunior * 12.25;
                    total+= numberSenior * 13.75;
                    break;
                case "road":
                    total+= numberJunior * 20;
                    total+= numberSenior * 21.50;
                    break;
            }
            total -= total * 0.05;

        System.out.printf("%.2f", total );

    }
}
