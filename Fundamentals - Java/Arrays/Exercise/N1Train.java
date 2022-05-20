package Arrays.Exercise;

import java.util.Scanner;
import java.util.Arrays;

public class N1Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] train = new int[n];
        int sum =0;
        for (int i = 0; i < n; i++) {
            train[i]= scanner.nextInt();
            sum+= train[i];
        }
        for (int i = 0; i <n ; i++) {
            System.out.print(train[i] + " ");

        }
        System.out.println();
        System.out.println(sum);

    }
}
