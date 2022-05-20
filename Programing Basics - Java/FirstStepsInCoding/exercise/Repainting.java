package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class Repainting {
/* програма за изчисляването на разходите за ремонт
* •	Предпазен найлон - 1.50 лв. за кв. метър
•	Боя - 14.50 лв. за литър
•	Разредител за боя - 5.00 лв. за литър
* + 10% от количеството боя
* +2 кв.м. найлон
* + и 0.40 лв. за торбичк
* Сумата, която се заплаща на майсторите за 1 час работа, е равна на 30% от сбора на всички разходи за материали.
*
* Входът се чете от конзолата и съдържа точно 4 реда:
1.	Необходимо количество найлон (в кв.м.) - цяло число в интервала [1... 100]
2.	Необходимо количество боя (в литри) - цяло число в интервала [1…100]
3.	Количество разредител (в литри) - цяло число в интервала [1…30]
4.	Часовете, за които майсторите ще свършат работата - цяло число в интервала [1…9]

*Да се отпечата на конзолата един ред:
•	"{сумата на всички разходи}"

* */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    int nylon = Integer.parseInt(scanner.nextLine());
    int paint = Integer.parseInt(scanner.nextLine());
    int thinner = Integer.parseInt(scanner.nextLine());
    int time = Integer.parseInt(scanner.nextLine());

    double nylonPrice = nylon * 1.50;
        double paintPrice = paint * 14.50;
        double thinnerPrice = thinner * 5;


        double paintPlusPercentage =paintPrice * 0.10;
        double totalpaint = paintPrice + paintPlusPercentage;
        double totalPrice =totalpaint +nylonPrice + thinnerPrice + 0.40 + 3;

        double timeMaster = totalPrice * time * 0.30;
        double totalTotal = timeMaster + totalPrice;
        System.out.println(totalTotal);




    }
}
