package preliminaryExam;

import java.util.Scanner;

public class N5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sea = Integer.parseInt(scanner.nextLine());
        int mountain = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();
        boolean isSold = false;
        boolean isSoldForMountain = false;
        int totalForSea = 0;
        int totalForMountain = 0;
        int total = 0;

        while (!text.equals("Stop")) {

            if (text.equals("sea")) {
                totalForSea++;
                if (totalForSea >= sea) {
                    isSold = true;
                    if(totalForSea == sea){
                        total += 680;
                    }

                }else {
                    total += 680;
                }
            } else {
                totalForMountain++;
                if (totalForMountain >= mountain) {
                    isSoldForMountain = true;
                    if(totalForMountain ==mountain){
                        total += 499;
                    }
                }else {
                    total += 499;
                }
            }

            if(isSold && isSoldForMountain){
                break;
            }

            text = scanner.nextLine();


        }
        if (isSold && isSoldForMountain) {
            System.out.println("Good job! Everything is sold.");
        }
        System.out.printf("Profit: %d leva.", total);
    }
}