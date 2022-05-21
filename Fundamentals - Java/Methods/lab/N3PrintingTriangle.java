package Methods.lab;

import java.util.Scanner;

public class N3PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
printTriangle(n);

    }
    public static void printTriangle(int n){
        for (int times = 1; times <=n ; times++) {
            for (int i = 1; i <= times ; i++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        for (int times = n; times >=1 ; times--) {
            for (int i = 1; i <times ; i++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
