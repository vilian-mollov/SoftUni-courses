package ForLoop.Exercises;

import java.util.Scanner;

public class N7TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfGroups = Integer.parseInt(scanner.nextLine());
        int musala = 0;
        int monblan = 0;
        int kalimandjaro = 0;
        int k2 = 0;
        int everest = 0;
        double allPeople = 0.0;

        for (int i = 1; i <=numberOfGroups ; i++) {

            int people = Integer.parseInt(scanner.nextLine());
            allPeople += people;
            if(people <= 5){
                musala += people;

            }else if (people <= 12){
                monblan += people;

            }else if(people <= 25){
                kalimandjaro += people;

            }else if (people <= 40){
                k2 += people;

            }else {
                everest += people;

            }

        }


        System.out.printf("%.2f%%%n", musala / allPeople * 100);
        System.out.printf("%.2f%%%n", monblan / allPeople * 100);
        System.out.printf("%.2f%%%n", kalimandjaro / allPeople * 100);
        System.out.printf("%.2f%%%n", k2 / allPeople * 100);
        System.out.printf("%.2f%%%n", everest / allPeople * 100);



    }
}
