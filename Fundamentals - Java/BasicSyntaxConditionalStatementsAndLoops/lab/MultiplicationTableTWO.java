package BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class MultiplicationTableTWO {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        for(int i = b; i <= 10; i++){
            System.out.printf("%d X %d = %d %n",a,i, a*i);

        }



    }
}
