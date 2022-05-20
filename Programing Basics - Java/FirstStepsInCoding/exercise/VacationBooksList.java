package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
    //От конзолата се четат 3 реда
        //1.	Брой страници
        //2.	Страници
        //3.	Броят на дните
        //цели числа
        //Да се отпечата на конзолата броят часове които трябва да чете всеки ден

        Scanner scanner = new Scanner(System.in);

        int numberOfPages = Integer.parseInt(scanner.nextLine());
        int pagesReadByHour = Integer.parseInt(scanner.nextLine());
        int numberOfDays = Integer.parseInt(scanner.nextLine());

        int timeNeededToReadByDay = numberOfPages / pagesReadByHour /  numberOfDays;

        System.out.println(timeNeededToReadByDay);


    }
}
