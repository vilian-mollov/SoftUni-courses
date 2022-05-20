package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class N10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountOfMoneyHeHas = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightsabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());
        double amountOfLightsabersNeeded = Math.ceil(numberOfStudents * 1.1);

        double totalPrice =amountOfLightsabersNeeded*priceOfLightsabers+numberOfStudents*priceOfBelts+numberOfStudents*priceOfRobes;

int counter = 0;
        for (int i = 1; i <=numberOfStudents ; i++) {
            counter++;
            if(counter==6){
                totalPrice-=priceOfBelts;
                counter=0;
            }


        }

        if(amountOfMoneyHeHas>=totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        }else{
            System.out.printf("George Lucas will need %.2flv more.",totalPrice-amountOfMoneyHeHas);
        }




    }
}
