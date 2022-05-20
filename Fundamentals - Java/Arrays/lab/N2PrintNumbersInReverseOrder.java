package Arrays.lab;

import java.util.Scanner;

public class N2PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int numbers = scanner.nextInt();
            array[i] = numbers;

        }

        for (int i = n-1; i >= 0; i--) {

            System.out.print(array[i]+" ");
        }
    }
}
