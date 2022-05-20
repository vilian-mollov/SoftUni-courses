package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
/*
* прочитаме от конзолата на отделни редове размерите му – дължина, широчина и височина в сантиметри.
*Да се напише програма, която изчислява литрите вода, която са необходими за напълването на аквариума.
*От конзолата се четат 4 реда:
1.	Дължина в см – цяло число в интервала [10 … 500]
2.	Широчина в см – цяло число в интервала [10 … 300]
3.	Височина в см – цяло число в интервала [10… 200]
4.	Процент  – реално число в интервала [0.000 … 100.000]

*Изход
Да се отпечата на конзолата едно число:
•	литрите вода, които ще събира аквариума.

* */
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentageUsed = Double.parseDouble(scanner.nextLine());

        int volume = length * width * height;
        double volumeTrue = volume * 0.001;
        double percent = percentageUsed * 0.01 ;
        double totalExit = volumeTrue * percent;
        double totalForWater = volumeTrue - totalExit ;
        System.out.println(totalForWater);

    }
}
