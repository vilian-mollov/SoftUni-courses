package ConditionalStatements.exercise;

import java.util.Scanner;

public class A8LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    String serialName = scanner.nextLine();
    int episodeLength = Integer.parseInt(scanner.nextLine());
    int breakTimeLength = Integer.parseInt(scanner.nextLine());

double timeForLunch = breakTimeLength /8.0;
double timeForRest = breakTimeLength / 4.0;

double totalTime = timeForLunch + timeForRest + episodeLength;

if(breakTimeLength >= totalTime){
    System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", serialName ,Math.ceil( breakTimeLength- totalTime));

}else {
    System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",serialName,Math.ceil(totalTime - breakTimeLength));

}




    }
}
