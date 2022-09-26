package WorkingWithAbstraction.RhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = n;

        for (int i = 1; i <= n; i++) {          //printing the upper part of the rhombus
            printingUpperPart(count, i);
            count--;
        }

        for (int i = n - 1; i >= 1; i--) {      //printing the lower part of the rhombus
            count++;
            printingLowerPart(count, i);
        }

    }

    private static void printingLowerPart(int count, int i) {
        for (int j = 0; j < count; j++) {
            System.out.print(" ");
        }
        for (int j = i; j >= 1; j--) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printingUpperPart(int count, int i) {
        for (int j = count - 1; j > 0; j--) {
            System.out.print(" ");
        }
        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
